package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ApexDetector : AbstractSourceFileLanguageDetector(
  name = "Apex",
  type = LanguageType.APEX,
  ".cls", ".trigger",
)
