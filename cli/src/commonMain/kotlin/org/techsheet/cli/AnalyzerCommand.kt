package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.CommonWriter
import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.techsheet.cli.reporter.ConsoleReporter

class AnalyzerCommand : CoreCliktCommand(name = "analyze") {
  private val verbose: Boolean by option("-v", "--verbose", help = "Enable verbose output")
    .flag()

  private val quiet: Boolean by option("-q", "--quiet", help = "Reduce output to a minimum")
    .flag()

  private val ci: Boolean by option("--ci", help = "Render the report without ANSI colors")
    .flag()

  private val source: String by argument(
    name = "source",
    help = "Project directory to analyze (defaults to current directory)",
  ).default("./")


  override fun run() {
    val minSeverity = when {
      verbose -> Severity.Debug
      quiet -> Severity.Warn
      else -> Severity.Info
    }

    val log = Logger(
      config = StaticConfig(minSeverity = minSeverity, logWriterList = listOf(CommonWriter())),
      tag = "analyze",
    )

    val ctx = AnalyzerContext(
      path = FileSystem.SYSTEM.canonicalize(source.toPath()),
      log = log,
    )

    log.i { "Starting analysis of project ${ctx.path}" }

    val sheet = Analyzer(log).analyze(ctx)

    log.i { "Analysis done, generating report" }

    if (!quiet) {
      ConsoleReporter(plain = ci).report(sheet)
    }
  }
}
