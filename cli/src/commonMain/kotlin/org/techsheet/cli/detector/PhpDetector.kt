package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PhpDetector : AbstractSourceFileLanguageDetector(
  name = "PHP",
  type = LanguageType.PHP,
  ".php",
)
