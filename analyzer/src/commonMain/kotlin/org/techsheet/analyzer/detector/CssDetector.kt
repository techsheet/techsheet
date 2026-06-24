package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class CssDetector : AbstractLanguageDetector(
  name = "CSS",
  type = LanguageType.CSS,
  ".css",
)
