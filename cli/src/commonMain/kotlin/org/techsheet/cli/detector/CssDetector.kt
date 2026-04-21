package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CssDetector : AbstractSourceFileLanguageDetector(
  name = "CSS",
  type = LanguageType.CSS,
  ".css",
)
