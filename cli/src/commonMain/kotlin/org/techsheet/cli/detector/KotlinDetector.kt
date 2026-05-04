package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class KotlinDetector : AbstractLanguageDetector(
  name = "Kotlin",
  type = LanguageType.KOTLIN,
  ".kt",
)
