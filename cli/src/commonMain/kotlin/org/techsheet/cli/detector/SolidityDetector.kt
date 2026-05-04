package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class SolidityDetector : AbstractSourceFileLanguageDetector(
  name = "Solidity",
  type = LanguageType.SOLIDITY,
  ".sol",
)
