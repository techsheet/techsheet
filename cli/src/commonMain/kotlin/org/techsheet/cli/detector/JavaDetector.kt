package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class JavaDetector : AbstractSourceFileLanguageDetector(
  name = "Java",
  type = LanguageType.JAVA,
  sourceExtension = ".java",
)
