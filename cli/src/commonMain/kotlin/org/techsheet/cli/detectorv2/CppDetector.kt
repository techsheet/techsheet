package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class CppDetector : AbstractSourceFileLanguageDetector(
  name = "C++",
  type = LanguageType.CPP,
  sourceExtension = ".cpp",
)
