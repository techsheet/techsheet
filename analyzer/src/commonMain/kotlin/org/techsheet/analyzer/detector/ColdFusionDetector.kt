package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ColdFusionDetector : AbstractLanguageDetector(
  name = "ColdFusion",
  type = LanguageType.COLDFUSION,
  ".cfm", ".cfc",
)
