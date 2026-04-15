package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.ProgrammingLanguageType

class JavaScriptDetector : AbstractSourceFileLanguageDetector(
  name = "JavaScript",
  type = ProgrammingLanguageType.JAVASCRIPT,
  sourceExtension = JS_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? = null

  companion object {
    private const val JS_EXT = ".js"
  }
}
