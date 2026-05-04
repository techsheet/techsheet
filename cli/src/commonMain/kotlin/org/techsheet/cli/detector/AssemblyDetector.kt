package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AssemblyDetector : AbstractLanguageDetector(
  name = "Assembly",
  type = LanguageType.ASSEMBLY,
  ".asm", ".s",
)
