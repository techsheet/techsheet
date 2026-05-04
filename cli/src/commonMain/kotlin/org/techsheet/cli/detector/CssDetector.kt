package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CssDetector : AbstractLanguageDetector(
  name = "CSS",
  type = LanguageType.CSS,
  ".css",
)
