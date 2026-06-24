package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ApexDetector : AbstractLanguageDetector(
  name = "Apex",
  type = LanguageType.APEX,
  ".cls", ".trigger",
)
