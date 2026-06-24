package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class CobolDetector : AbstractLanguageDetector(
  name = "COBOL",
  type = LanguageType.COBOL,
  ".cbl", ".cob", ".cobol",
)
