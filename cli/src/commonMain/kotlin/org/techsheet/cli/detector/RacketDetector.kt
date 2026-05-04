package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class RacketDetector : AbstractLanguageDetector(
  name = "Racket",
  type = LanguageType.RACKET,
  ".rkt",
)
