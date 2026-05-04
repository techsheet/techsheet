package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class FortranDetector : AbstractLanguageDetector(
  name = "Fortran",
  type = LanguageType.FORTRAN,
  ".f", ".f90", ".f95",
)
