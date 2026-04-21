package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class HtmlDetector : AbstractSourceFileLanguageDetector(
  name = "HTML",
  type = LanguageType.HTML,
  ".html",
  ".htm",
)
