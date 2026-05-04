package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CobolDetector : AbstractSourceFileLanguageDetector(
  name = "COBOL",
  type = LanguageType.COBOL,
  ".cbl", ".cob", ".cobol",
)
