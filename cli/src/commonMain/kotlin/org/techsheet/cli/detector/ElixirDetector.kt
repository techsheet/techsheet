package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ElixirDetector : AbstractSourceFileLanguageDetector(
  name = "Elixir",
  type = LanguageType.ELIXIR,
  ".ex", ".exs",
)
