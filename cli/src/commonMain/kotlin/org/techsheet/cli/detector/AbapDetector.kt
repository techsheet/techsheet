package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AbapDetector : AbstractLanguageDetector(
  name = "ABAP",
  type = LanguageType.ABAP,
  ".abap",
)
