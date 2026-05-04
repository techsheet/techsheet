package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class VhdlDetector : AbstractLanguageDetector(
  name = "VHDL",
  type = LanguageType.VHDL,
  ".vhd", ".vhdl",
)
