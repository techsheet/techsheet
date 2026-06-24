package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class HtmlDetector : AbstractLanguageDetector(
  name = "HTML",
  type = LanguageType.HTML,
  ".html",
  ".htm",
)
