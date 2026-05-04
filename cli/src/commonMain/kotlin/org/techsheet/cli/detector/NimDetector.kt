package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class NimDetector : AbstractSourceFileLanguageDetector(
  name = "Nim",
  type = LanguageType.NIM,
  ".nim",
)
