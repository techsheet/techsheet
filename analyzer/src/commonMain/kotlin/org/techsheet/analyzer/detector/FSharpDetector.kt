package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class FSharpDetector : AbstractLanguageDetector(
  name = "F#",
  type = LanguageType.FSHARP,
  ".fs", ".fsx",
)
