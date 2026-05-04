package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class GroovyDetector : AbstractLanguageDetector(
  name = "Groovy",
  type = LanguageType.GROOVY,
  ".groovy",
)
