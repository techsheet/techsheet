package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class CSharpDetector : AbstractSourceFileLanguageDetector(
  name = "C#",
  type = LanguageType.CSHARP,
  sourceExtension = ".cs",
)
