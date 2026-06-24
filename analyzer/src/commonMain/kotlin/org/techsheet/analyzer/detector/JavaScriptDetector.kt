package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class JavaScriptDetector : AbstractLanguageDetector(
  name = "JavaScript",
  type = LanguageType.JAVASCRIPT,
  ".js",
)
