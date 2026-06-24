package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class RacketDetector : AbstractLanguageDetector(
  name = "Racket",
  type = LanguageType.RACKET,
  ".rkt",
)
