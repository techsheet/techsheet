package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class VhdlDetector : AbstractLanguageDetector(
  name = "VHDL",
  type = LanguageType.VHDL,
  ".vhd", ".vhdl",
)
