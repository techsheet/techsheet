package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PascalDetector : AbstractLanguageDetector(
  name = "Pascal",
  type = LanguageType.PASCAL,
  ".pas", ".dpr",
)
