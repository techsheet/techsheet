package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AsciiDocDetector : AbstractLanguageDetector(
  name = "AsciiDoc",
  type = LanguageType.ASCIIDOC,
  ".adoc",
  ".asciidoc",
  ".asc",
)
