package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class AwkDetector : AbstractLanguageDetector(
  name = "Awk",
  type = LanguageType.AWK,
  ".awk",
)
