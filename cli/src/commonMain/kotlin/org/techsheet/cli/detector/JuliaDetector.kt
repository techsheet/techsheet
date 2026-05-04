package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class JuliaDetector : AbstractSourceFileLanguageDetector(
  name = "Julia",
  type = LanguageType.JULIA,
  ".jl",
)
