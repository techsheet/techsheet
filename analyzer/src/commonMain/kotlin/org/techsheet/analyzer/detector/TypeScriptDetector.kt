package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class TypeScriptDetector : AbstractLanguageDetector(
  name = "TypeScript",
  type = LanguageType.TYPESCRIPT,
  ".ts",
)
