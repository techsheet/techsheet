package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PhpDetector : AbstractLanguageDetector(
  name = "PHP",
  type = LanguageType.PHP,
  ".php",
)
