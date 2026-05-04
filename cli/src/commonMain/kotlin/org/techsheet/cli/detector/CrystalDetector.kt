package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class CrystalDetector : AbstractSourceFileLanguageDetector(
  name = "Crystal",
  type = LanguageType.CRYSTAL,
  ".cr",
)
