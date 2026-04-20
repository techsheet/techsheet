package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class ScalaDetector : AbstractSourceFileLanguageDetector(
  name = "Scala",
  type = LanguageType.SCALA,
  sourceExtension = ".scala",
)
