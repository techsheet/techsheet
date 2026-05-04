package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class FSharpDetector : AbstractSourceFileLanguageDetector(
  name = "F#",
  type = LanguageType.FSHARP,
  ".fs", ".fsx",
)
