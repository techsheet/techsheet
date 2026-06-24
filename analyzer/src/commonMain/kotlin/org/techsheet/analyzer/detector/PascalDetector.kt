package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class PascalDetector : AbstractLanguageDetector(
  name = "Pascal",
  type = LanguageType.PASCAL,
  ".pas", ".dpr",
)
