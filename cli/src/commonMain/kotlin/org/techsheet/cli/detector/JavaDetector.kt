package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class JavaDetector : AbstractLanguageDetector(
  name = "Java",
  type = LanguageType.JAVA,
  ".java",
)
