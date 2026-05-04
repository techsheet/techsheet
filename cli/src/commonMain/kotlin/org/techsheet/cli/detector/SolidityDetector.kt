package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class SolidityDetector : AbstractLanguageDetector(
  name = "Solidity",
  type = LanguageType.SOLIDITY,
  ".sol",
)
