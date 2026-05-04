package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class TclDetector : AbstractSourceFileLanguageDetector(
  name = "Tcl",
  type = LanguageType.TCL,
  ".tcl",
)
