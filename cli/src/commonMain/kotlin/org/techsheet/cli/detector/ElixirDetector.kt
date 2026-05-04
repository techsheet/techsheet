package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ElixirDetector : AbstractLanguageDetector(
  name = "Elixir",
  type = LanguageType.ELIXIR,
  ".ex", ".exs",
)
