package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class AsciiDocDetector : AbstractLanguageDetector(
  name = "AsciiDoc",
  type = LanguageType.ASCIIDOC,
  ".adoc",
  ".asciidoc",
  ".asc",
)
