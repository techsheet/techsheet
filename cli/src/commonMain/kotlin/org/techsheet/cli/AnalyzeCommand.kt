package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.techsheet.cli.detector.GradleDetector
import org.techsheet.cli.detector.JavaDetector
import org.techsheet.cli.detector.KotlinDetector
import org.techsheet.cli.detector.MavenDetector
import org.techsheet.cli.detector.ScalaDetector
import org.techsheet.cli.domain.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.reporter.ConsoleReporter
import org.techsheet.cli.reporter.Reporter

class AnalyzeCommand : CoreCliktCommand(name = "analyze") {
  private val verbose: Boolean by option("-v", "--verbose", help = "Enable verbose output")
    .flag()

  private val quiet: Boolean by option("-q", "--quiet", help = "Reduce output to a minimum")
    .flag()

  private val source: String by argument(
    name = "source",
    help = "Project directory to analyze (defaults to current directory)",
  ).default("./")

  private val detectors = listOf(
    GradleDetector(),
    MavenDetector(),
    JavaDetector(),
    KotlinDetector(),
    ScalaDetector(),
  )

  private val reporter: Reporter = ConsoleReporter()

  override fun run() {
    val minSeverity = when {
      verbose -> Severity.Debug
      quiet -> Severity.Warn
      else -> Severity.Info
    }

    val log = Logger(
      config = StaticConfig(minSeverity = minSeverity, logWriterList = listOf(platformLogWriter())),
      tag = "analyze",
    )

    val ctx = AnalyzerContext(
      path = FileSystem.SYSTEM.canonicalize(source.toPath()),
      log = log,
    )

    log.i { "Starting analysis of project ${ctx.path}" }

    val sheet = detectors
      .fold(TechSheet.empty()) { acc, detector ->
        log.i { "Running ${detector.name} detector" }
        detector.detect(ctx, acc)
      }

    reporter.report(ctx, sheet)
  }
}
