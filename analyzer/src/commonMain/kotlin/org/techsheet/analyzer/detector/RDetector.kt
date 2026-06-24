package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class RDetector : AbstractLanguageDetector(
  name = "R",
  type = LanguageType.R,
  ".r",
)
