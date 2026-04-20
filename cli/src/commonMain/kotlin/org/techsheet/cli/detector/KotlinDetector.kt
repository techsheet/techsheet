package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class KotlinDetector : AbstractSourceFileLanguageDetector(
  name = "Kotlin",
  type = LanguageType.KOTLIN,
  sourceExtension = ".kt",
)
