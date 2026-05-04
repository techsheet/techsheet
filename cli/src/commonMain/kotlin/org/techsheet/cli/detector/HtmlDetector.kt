package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class HtmlDetector : AbstractLanguageDetector(
  name = "HTML",
  type = LanguageType.HTML,
  ".html",
  ".htm",
)
