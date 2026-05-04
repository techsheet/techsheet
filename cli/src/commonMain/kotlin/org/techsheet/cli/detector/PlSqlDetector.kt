package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PlSqlDetector : AbstractSourceFileLanguageDetector(
  name = "PL/SQL",
  type = LanguageType.PLSQL,
  ".pls", ".pks", ".pkb",
)
