package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ZigDetector : AbstractLanguageDetector(
  name = "Zig",
  type = LanguageType.ZIG,
  ".zig",
)
