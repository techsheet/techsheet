package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class VhdlDetector : AbstractSourceFileLanguageDetector(
  name = "VHDL",
  type = LanguageType.VHDL,
  ".vhd", ".vhdl",
)
