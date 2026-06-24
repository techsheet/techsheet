package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class PlSqlDetector : AbstractLanguageDetector(
  name = "PL/SQL",
  type = LanguageType.PLSQL,
  ".pls", ".pks", ".pkb",
)
