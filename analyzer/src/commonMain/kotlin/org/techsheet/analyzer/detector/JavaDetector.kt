package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class JavaDetector : AbstractLanguageDetector(
  name = "Java",
  type = LanguageType.JAVA,
  ".java",
)
