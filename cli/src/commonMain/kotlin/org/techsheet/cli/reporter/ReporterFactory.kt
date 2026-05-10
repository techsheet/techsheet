package org.techsheet.cli.reporter

import okio.FileSystem
import org.techsheet.schema.TechSheet

data class ReporterFactory(
    val techSheet: TechSheet,
    val readonly: Boolean,
    val fs: FileSystem,
) {

  val noop: Reporter by lazy { NoopReporter(fs) }

  val yaml: Reporter by lazy { YamlReporter(techSheet, fs) }

  val json: Reporter by lazy { JsonReporter(techSheet, fs) }

  val markdown: Reporter by lazy { MarkdownReporter(techSheet, fs) }

  val html: Reporter by lazy { HtmlReporter(techSheet, fs) }
}
