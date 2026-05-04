package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class SqlDetector : AbstractLanguageDetector(
  name = "SQL",
  type = LanguageType.SQL,
  ".sql",
)
