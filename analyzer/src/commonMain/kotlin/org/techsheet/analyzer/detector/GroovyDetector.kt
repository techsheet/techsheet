package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class GroovyDetector : AbstractLanguageDetector(
  name = "Groovy",
  type = LanguageType.GROOVY,
  ".groovy",
)
