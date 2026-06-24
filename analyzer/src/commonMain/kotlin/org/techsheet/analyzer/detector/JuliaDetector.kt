package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class JuliaDetector : AbstractLanguageDetector(
  name = "Julia",
  type = LanguageType.JULIA,
  ".jl",
)
