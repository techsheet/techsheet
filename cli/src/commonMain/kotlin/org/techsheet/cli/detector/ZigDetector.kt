package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ZigDetector : AbstractLanguageDetector(
  name = "Zig",
  type = LanguageType.ZIG,
  ".zig",
)
