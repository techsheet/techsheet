package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class AsciiDocDetector : AbstractSourceFileLanguageDetector(
  name = "AsciiDoc",
  type = LanguageType.ASCIIDOC,
  ".adoc",
  ".asciidoc",
  ".asc",
)
