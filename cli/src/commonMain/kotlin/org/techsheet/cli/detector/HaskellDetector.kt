package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class HaskellDetector : AbstractSourceFileLanguageDetector(
  name = "Haskell",
  type = LanguageType.HASKELL,
  ".hs",
)
