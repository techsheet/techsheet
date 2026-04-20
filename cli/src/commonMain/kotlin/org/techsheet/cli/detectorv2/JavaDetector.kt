package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class JavaDetector : AbstractSourceFileLanguageDetector(
  name = "Java",
  type = LanguageType.JAVA,
  sourceExtension = ".java",
)
