package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class TypeScriptDetector : AbstractSourceFileLanguageDetector(
  name = "TypeScript",
  type = LanguageType.TYPESCRIPT,
  sourceExtension = ".ts",
)
