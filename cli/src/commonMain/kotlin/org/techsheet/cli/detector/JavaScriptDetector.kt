package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class JavaScriptDetector : AbstractSourceFileLanguageDetector(
  name = "JavaScript",
  type = LanguageType.JAVASCRIPT,
  ".js",
)
