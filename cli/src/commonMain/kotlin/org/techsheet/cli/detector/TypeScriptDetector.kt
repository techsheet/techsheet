package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class TypeScriptDetector : AbstractSourceFileLanguageDetector(
  name = "TypeScript",
  type = LanguageType.TYPESCRIPT,
  sourceExtension = ".ts",
)
