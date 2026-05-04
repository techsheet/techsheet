package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ColdFusionDetector : AbstractLanguageDetector(
  name = "ColdFusion",
  type = LanguageType.COLDFUSION,
  ".cfm", ".cfc",
)
