package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.optionalValue
import okio.FileNotFoundException
import okio.FileSystem
import okio.IOException
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.reporter.ReporterFactory
import org.techsheet.cli.reporter.YamlReporter
import org.techsheet.cli.util.ConsolePrinter
import kotlin.time.measureTimedValue

class AnalyzerCommand : CliktCommand(name = "analyze") {

  private val verbose: Boolean by option(
    "-v",
    "--verbose",
    help = "Enable verbose output"
  ).flag()

  private val quiet: Boolean by option(
    "-q",
    "--quiet",
    help = "Reduce output to a minimum"
  ).flag()

  private val ci: Boolean by option(
    "--ci",
    help = "Enable CI mode, suppresses colors and interaction"
  ).flag()

  private val readOnly: Boolean by option(
    "-r",
    "--read-only",
    help = "Skip writing the YAML report (implied by --ci)"
  ).flag()

  private val file: String? by option(
    "--file",
    help = "Path to the techsheet.yml file (default: techsheet.yml inside the source directory)"
  )

  private val reportJson: String? by option(
    "--report-json",
    help = "Export JSON report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.json")

  private val reportMarkdown: String? by option(
    "--report-markdown",
    help = "Export Markdown report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.md")

  private val reportHtml: String? by option(
    "--report-html",
    help = "Export HTML report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.html")

  private val outputYaml: Boolean by option(
    "--output-yaml",
    help = "Print YAML to stdout instead of the console report"
  ).flag()

  private val outputJson: Boolean by option(
    "--output-json",
    help = "Print JSON to stdout instead of the console report"
  ).flag()

  private val outputMarkdown: Boolean by option(
    "--output-markdown",
    help = "Print Markdown to stdout instead of the console report"
  ).flag()

  private val outputHtml: Boolean by option(
    "--output-html",
    help = "Print HTML to stdout instead of the console report"
  ).flag()

  private val source: String by argument(
    name = "source",
    help = "Project directory to analyze (defaults to current directory)",
  ).default("./")

  override fun help(context: Context): String = """
    Analyze a project directory and report detected tech stack.

    Detects used languages, frameworks, services, and tools. Results are written to techsheet.yml (or --file) and
    printed as a console report.
  """.trimIndent()

  override fun run() {

    val minSeverity = when {
      verbose -> Severity.Debug
      quiet -> Severity.Warn
      else -> Severity.Info
    }

    val log = Logger(
      config = StaticConfig(minSeverity = minSeverity, logWriterList = listOf(PlainLogWriter())),
      tag = "analyze",
    )

    val fs = FileSystem.SYSTEM

    val activeOutputs = listOf(outputYaml, outputJson, outputMarkdown, outputHtml)
      .filter { it }

    if (activeOutputs.size > 1) {
      throw CliktError("Only one --output-* flag may be active at a time")
    }

    val sourcePath = fs.canonicalize(source.toPath())

    val ctx = AnalyzerContext(
      path = sourcePath,
      log = log,
    )

    log.i { "Starting project analysis..." }
    val sheet = measureTimedValue { Analyzer(log).analyze(ctx) }
      .also { log.i { "Project analyzed in ${it.duration}." } }
      .value

    //FIXME: Include user data from existing report once implemented
    val report = TechSheetReport.of(sheet)
    val reporters = ReporterFactory(
      report = report,
      readonly = readOnly,
      fs = fs
    )

    val targetFile = file?.toPath(normalize = true) ?: (sourcePath / YamlReporter.DEFAULT_FILE_NAME)

    if (!reporters.readonly) {
      log.i { "Writing YAML report to: $targetFile" }
      catchErrors("YAML", targetFile) { reporters.yaml.report(targetFile) }
    }

    reportJson?.let {
      val target = it.toPath(normalize = true)
      log.i { "Writing JSON report to: $target" }
      catchErrors("JSON", target) { reporters.json.report(target) }
    }

    reportMarkdown?.let {
      val target = it.toPath(normalize = true)
      log.i { "Writing Markdown report to: $target" }
      catchErrors("Markdown", target) { reporters.markdown.report(target) }
    }

    reportHtml?.let {
      val target = it.toPath(normalize = true)
      log.i { "Writing HTML report to: $target" }
      catchErrors("HTML", target) { reporters.html.report(target) }
    }

    val stdout = when {
      outputYaml -> reporters.yaml.serialize()
      outputJson -> reporters.json.serialize()
      outputMarkdown -> reporters.markdown.serialize()
      outputHtml -> reporters.html.serialize()
      else -> null
    }

    when {
      stdout != null ->
        echo(stdout, true)
      !quiet ->
        ConsolePrinter(color = !ci).printReport(report)
    }
  }

  private inline fun catchErrors(format: String, target: okio.Path, write: () -> Unit) {
    try {
      write()
    } catch (e: FileNotFoundException) {
      throw CliktError("Cannot write $format report to $target: ${e.message ?: "path not found or not writable"}")
    } catch (e: IOException) {
      throw CliktError("I/O error writing $format report to $target: ${e.message ?: e::class.simpleName}")
    } catch (e: Exception) {
      val detail = listOfNotNull(e::class.simpleName, e.message).joinToString(": ")
      throw CliktError("Unexpected error writing $format report to $target: $detail")
    }
  }
}
