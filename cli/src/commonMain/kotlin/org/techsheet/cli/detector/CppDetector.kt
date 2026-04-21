package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CppDetector : AbstractSourceFileLanguageDetector(
  name = "C++",
  type = LanguageType.CPP,
  ".cpp",
)
