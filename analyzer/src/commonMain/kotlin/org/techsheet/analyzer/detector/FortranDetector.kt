package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class FortranDetector : AbstractLanguageDetector(
  name = "Fortran",
  type = LanguageType.FORTRAN,
  ".f", ".f90", ".f95",
)
