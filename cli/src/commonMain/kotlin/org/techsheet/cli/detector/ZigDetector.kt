package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ZigDetector : AbstractSourceFileLanguageDetector(
  name = "Zig",
  type = LanguageType.ZIG,
  ".zig",
)
