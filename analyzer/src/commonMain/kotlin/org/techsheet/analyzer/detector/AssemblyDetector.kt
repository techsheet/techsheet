package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class AssemblyDetector : AbstractLanguageDetector(
  name = "Assembly",
  type = LanguageType.ASSEMBLY,
  ".asm", ".s",
)
