package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class JuliaDetector : AbstractLanguageDetector(
  name = "Julia",
  type = LanguageType.JULIA,
  ".jl",
)
