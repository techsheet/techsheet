package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ScalaDetector : AbstractSourceFileLanguageDetector(
  name = "Scala",
  type = LanguageType.SCALA,
  ".scala",
)
