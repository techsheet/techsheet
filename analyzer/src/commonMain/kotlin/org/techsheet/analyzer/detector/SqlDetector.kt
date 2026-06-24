package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class SqlDetector : AbstractLanguageDetector(
  name = "SQL",
  type = LanguageType.SQL,
  ".sql",
)
