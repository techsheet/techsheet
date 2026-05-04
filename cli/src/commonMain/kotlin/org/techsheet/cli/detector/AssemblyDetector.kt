package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AssemblyDetector : AbstractSourceFileLanguageDetector(
  name = "Assembly",
  type = LanguageType.ASSEMBLY,
  ".asm", ".s",
)
