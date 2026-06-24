package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class VisualBasicDetector : AbstractLanguageDetector(
  name = "Visual Basic",
  type = LanguageType.VISUAL_BASIC,
  ".vb", ".vbs",
)
