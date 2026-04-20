package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CSharpDetector : AbstractSourceFileLanguageDetector(
  name = "C#",
  type = LanguageType.CSHARP,
  sourceExtension = ".cs",
)
