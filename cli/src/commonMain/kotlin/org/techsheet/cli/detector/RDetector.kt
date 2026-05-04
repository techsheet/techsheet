package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class RDetector : AbstractSourceFileLanguageDetector(
  name = "R",
  type = LanguageType.R,
  ".r",
)
