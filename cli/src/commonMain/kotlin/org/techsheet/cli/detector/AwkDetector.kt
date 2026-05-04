package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AwkDetector : AbstractLanguageDetector(
  name = "Awk",
  type = LanguageType.AWK,
  ".awk",
)
