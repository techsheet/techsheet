package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class CppDetector : AbstractLanguageDetector(
  name = "C++",
  type = LanguageType.CPP,
  ".cpp",
)
