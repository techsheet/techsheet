package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class TypeScriptDetector : AbstractLanguageDetector(
  name = "TypeScript",
  type = LanguageType.TYPESCRIPT,
  ".ts",
)
