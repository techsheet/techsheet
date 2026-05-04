package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CSharpDetector : AbstractLanguageDetector(
  name = "C#",
  type = LanguageType.CSHARP,
  ".cs",
)
