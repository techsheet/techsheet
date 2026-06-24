package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class PhpDetector : AbstractLanguageDetector(
  name = "PHP",
  type = LanguageType.PHP,
  ".php",
)
