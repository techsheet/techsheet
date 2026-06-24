package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class MarkdownDetector : AbstractLanguageDetector(
  name = "Markdown",
  type = LanguageType.MARKDOWN,
  ".md",
  ".markdown",
)
