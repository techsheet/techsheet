package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class HaskellDetector : AbstractLanguageDetector(
  name = "Haskell",
  type = LanguageType.HASKELL,
  ".hs",
)
