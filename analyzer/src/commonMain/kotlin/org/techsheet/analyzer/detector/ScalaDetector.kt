package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ScalaDetector : AbstractLanguageDetector(
  name = "Scala",
  type = LanguageType.SCALA,
  ".scala",
)
