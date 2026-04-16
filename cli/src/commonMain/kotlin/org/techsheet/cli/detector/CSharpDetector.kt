package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.LanguageType

class CSharpDetector : AbstractSourceFileLanguageDetector(
  name = "C#",
  type = LanguageType.CSHARP,
  sourceExtension = CS_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? = null

  companion object {
    private const val CS_EXT = ".cs"
  }
}
