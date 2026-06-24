package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class CSharpDetector : AbstractLanguageDetector(
  name = "C#",
  type = LanguageType.CSHARP,
  ".cs",
)
