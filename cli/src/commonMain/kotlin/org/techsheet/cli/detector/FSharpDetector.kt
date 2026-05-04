package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class FSharpDetector : AbstractLanguageDetector(
  name = "F#",
  type = LanguageType.FSHARP,
  ".fs", ".fsx",
)
