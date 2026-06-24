package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ElixirDetector : AbstractLanguageDetector(
  name = "Elixir",
  type = LanguageType.ELIXIR,
  ".ex", ".exs",
)
