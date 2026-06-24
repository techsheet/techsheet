package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class AbapDetector : AbstractLanguageDetector(
  name = "ABAP",
  type = LanguageType.ABAP,
  ".abap",
)
