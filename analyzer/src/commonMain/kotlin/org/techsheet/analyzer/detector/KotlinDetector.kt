package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class KotlinDetector : AbstractLanguageDetector(
  name = "Kotlin",
  type = LanguageType.KOTLIN,
  ".kt",
)
