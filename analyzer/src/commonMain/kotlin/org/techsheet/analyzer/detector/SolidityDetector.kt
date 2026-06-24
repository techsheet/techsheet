package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class SolidityDetector : AbstractLanguageDetector(
  name = "Solidity",
  type = LanguageType.SOLIDITY,
  ".sol",
)
