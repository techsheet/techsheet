package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class HaskellDetector : AbstractLanguageDetector(
  name = "Haskell",
  type = LanguageType.HASKELL,
  ".hs",
)
