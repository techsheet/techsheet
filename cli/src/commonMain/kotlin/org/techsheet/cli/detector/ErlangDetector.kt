package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ErlangDetector : AbstractLanguageDetector(
  name = "Erlang",
  type = LanguageType.ERLANG,
  ".erl",
)
