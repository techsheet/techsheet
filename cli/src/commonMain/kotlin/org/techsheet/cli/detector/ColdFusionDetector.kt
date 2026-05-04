package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ColdFusionDetector : AbstractSourceFileLanguageDetector(
  name = "ColdFusion",
  type = LanguageType.COLDFUSION,
  ".cfm", ".cfc",
)
