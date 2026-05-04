package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class FortranDetector : AbstractSourceFileLanguageDetector(
  name = "Fortran",
  type = LanguageType.FORTRAN,
  ".f", ".f90", ".f95",
)
