package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ScssDetector : AbstractSourceFileLanguageDetector(
  name = "SCSS/SASS",
  type = LanguageType.SCSS,
  ".scss",
  ".sass",
)
