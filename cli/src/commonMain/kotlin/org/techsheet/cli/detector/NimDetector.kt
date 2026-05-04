package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class NimDetector : AbstractLanguageDetector(
  name = "Nim",
  type = LanguageType.NIM,
  ".nim",
)
