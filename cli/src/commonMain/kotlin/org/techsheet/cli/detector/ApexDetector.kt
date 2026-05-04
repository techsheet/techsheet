package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ApexDetector : AbstractLanguageDetector(
  name = "Apex",
  type = LanguageType.APEX,
  ".cls", ".trigger",
)
