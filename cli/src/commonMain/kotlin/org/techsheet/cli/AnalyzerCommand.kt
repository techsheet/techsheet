package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.CoreCliktCommand
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
import org.techsheet.cli.reporter.ConsoleReporter
import org.techsheet.cli.reporter.HtmlReporter
import org.techsheet.cli.reporter.JsonReporter
import org.techsheet.cli.reporter.MarkdownReporter
import org.techsheet.cli.reporter.YamlReporter
import kotlin.time.measureTimedValue

class AnalyzerCommand : CoreCliktCommand(name = "analyze") {

  private val verbose: Boolean by option("-v", "--verbose", help = "Enable verbose output")
    .flag()

  private val quiet: Boolean by option("-q", "--quiet", help = "Reduce output to a minimum")
    .flag()

  private val ci: Boolean by option("--ci", help = "Enable CI mode, suppresses colors and interaction")
    .flag()

  private val yaml: String? by option(
    "-y",
    "--yaml",
    help = "Export YAML report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.yml")

  private val json: String? by option(
    "-j",
    "--json",
    help = "Export JSON report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.json")

  private val markdown: String? by option(
    "-m",
    "--markdown",
    help = "Export Markdown report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.md")

  private val html: String? by option(
    "--html",
    help = "Export HTML report (optionally specify output path with =)"
  )
    .optionalValue("techsheet.html")

  private val console: Boolean by option(
    "-c",
    "--console",
    help = "Print the console report (implicit when no other reporter is specified)"
  )
    .flag()

  private val source: String by argument(
    name = "source",
    help = "Project directory to analyze (defaults to current directory)",
  ).default("./")

  override fun help(context: Context): String = """
    Analyze a project directory and report detected tech stack.

    Walks the given directory looking for manifest files, sources, etc. identify languages, frameworks, services, and tools.
    By default the result is printed as a console report. Use --markdown, --html, --yaml etc. for other reporting formats.

    Examples:

      analyze                         Analyze current directory & print console report (default)
      analyze /projects/yx --yaml     Analyze specific directory and write a YAML report
      analyze --json=out/stack.json   Write JSON report to a custom path
      analyze -y -j -m                Export YAML, JSON and Markdown
      analyze --console --yaml        Both console and YAML
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

    val sourcePath = FileSystem.SYSTEM.canonicalize(source.toPath())

    val ctx = AnalyzerContext(
      path = sourcePath,
      log = log,
    )

    log.i { "Starting project analysis..." }

    val timed = measureTimedValue { Analyzer(log).analyze(ctx) }
    val sheet = timed.value

    log.i { "" }
    log.i { "Project analyzed in ${timed.duration}." }

    yaml?.let {
      val target = sourcePath / it.toPath()
      log.i { "Writing YAML report to: $target" }
      writeReport("YAML", target) { YamlReporter(target).report(sheet) }
    }

    json?.let {
      val target = sourcePath / it.toPath()
      log.i { "Writing JSON report to: $target" }
      writeReport("JSON", target) { JsonReporter(target).report(sheet) }
    }

    markdown?.let {
      val target = sourcePath / it.toPath()
      log.i { "Writing Markdown report to: $target" }
      writeReport("Markdown", target) { MarkdownReporter(target).report(sheet) }
    }

    html?.let {
      val target = sourcePath / it.toPath()
      log.i { "Writing HTML report to: $target" }
      writeReport("HTML", target) { HtmlReporter(target).report(sheet) }
    }

    val anyExplicit = yaml != null || json != null || markdown != null || html != null || console
    if (console || !anyExplicit) {
      log.i { "" }
      ConsoleReporter(plain = ci).report(sheet)
    }
  }

  private inline fun writeReport(format: String, target: okio.Path, write: () -> Unit) {
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
