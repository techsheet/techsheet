package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class JavaScriptDetector : AbstractLanguageDetector(
  name = "JavaScript",
  type = LanguageType.JAVASCRIPT,
  ".js",
)
