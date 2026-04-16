package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.LanguageType

class CppDetector : AbstractSourceFileLanguageDetector(
  name = "C++",
  type = LanguageType.CPP,
  sourceExtension = CPP_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? = null

  companion object {
    private const val CPP_EXT = ".cpp"
  }
}
