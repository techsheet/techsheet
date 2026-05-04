package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AbapDetector : AbstractSourceFileLanguageDetector(
  name = "ABAP",
  type = LanguageType.ABAP,
  ".abap",
)
