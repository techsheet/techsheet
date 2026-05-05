package org.techsheet.cli.reporter

import okio.FileSystem
import org.techsheet.cli.domain.TechSheetReport

data class ReporterFactory(
  val report: TechSheetReport,
  val readonly: Boolean,
  val fs: FileSystem,
) {

  val noop: Reporter by lazy { NoopReporter(report, fs) }

  val yaml: Reporter by lazy { YamlReporter(report, fs) }

  val json: Reporter by lazy { JsonReporter(report, fs) }

  val markdown: Reporter by lazy { MarkdownReporter(report, fs) }

  val html: Reporter by lazy { HtmlReporter(report, fs) }

  val console: Reporter by lazy { ConsoleReporter(report, fs, plain = readonly) }
}
