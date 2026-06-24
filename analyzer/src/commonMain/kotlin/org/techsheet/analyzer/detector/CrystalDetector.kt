package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class CrystalDetector : AbstractLanguageDetector(
  name = "Crystal",
  type = LanguageType.CRYSTAL,
  ".cr",
)
