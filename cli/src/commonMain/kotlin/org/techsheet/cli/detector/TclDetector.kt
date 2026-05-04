package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class TclDetector : AbstractLanguageDetector(
  name = "Tcl",
  type = LanguageType.TCL,
  ".tcl",
)
