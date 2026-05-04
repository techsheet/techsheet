package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PascalDetector : AbstractSourceFileLanguageDetector(
  name = "Pascal",
  type = LanguageType.PASCAL,
  ".pas", ".dpr",
)
