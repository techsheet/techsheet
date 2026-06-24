package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ScssDetector : AbstractLanguageDetector(
  name = "SCSS/SASS",
  type = LanguageType.SCSS,
  ".scss",
  ".sass",
)
