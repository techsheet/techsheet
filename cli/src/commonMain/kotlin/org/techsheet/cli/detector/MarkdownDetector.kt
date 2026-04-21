package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class MarkdownDetector : AbstractSourceFileLanguageDetector(
  name = "Markdown",
  type = LanguageType.MARKDOWN,
  ".md",
  ".markdown",
)
