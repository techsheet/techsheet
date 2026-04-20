package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class JavaScriptDetector : AbstractSourceFileLanguageDetector(
  name = "JavaScript",
  type = LanguageType.JAVASCRIPT,
  sourceExtension = ".js",
)
