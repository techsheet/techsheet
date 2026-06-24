package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class TclDetector : AbstractLanguageDetector(
  name = "Tcl",
  type = LanguageType.TCL,
  ".tcl",
)
