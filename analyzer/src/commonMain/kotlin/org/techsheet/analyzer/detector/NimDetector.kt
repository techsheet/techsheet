package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class NimDetector : AbstractLanguageDetector(
  name = "Nim",
  type = LanguageType.NIM,
  ".nim",
)
