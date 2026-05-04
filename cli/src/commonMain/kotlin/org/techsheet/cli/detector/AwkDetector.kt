package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AwkDetector : AbstractSourceFileLanguageDetector(
  name = "Awk",
  type = LanguageType.AWK,
  ".awk",
)
