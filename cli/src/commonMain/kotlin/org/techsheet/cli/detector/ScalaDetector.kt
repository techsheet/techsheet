package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ScalaDetector : AbstractLanguageDetector(
  name = "Scala",
  type = LanguageType.SCALA,
  ".scala",
)
