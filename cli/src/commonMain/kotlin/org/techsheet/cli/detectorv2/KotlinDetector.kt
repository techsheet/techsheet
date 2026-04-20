package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class KotlinDetector : AbstractSourceFileLanguageDetector(
  name = "Kotlin",
  type = LanguageType.KOTLIN,
  sourceExtension = ".kt",
)
