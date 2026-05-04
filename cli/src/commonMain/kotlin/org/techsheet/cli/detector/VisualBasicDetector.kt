package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class VisualBasicDetector : AbstractSourceFileLanguageDetector(
  name = "Visual Basic",
  type = LanguageType.VISUAL_BASIC,
  ".vb", ".vbs",
)
