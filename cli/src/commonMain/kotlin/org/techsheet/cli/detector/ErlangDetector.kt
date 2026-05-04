package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ErlangDetector : AbstractSourceFileLanguageDetector(
  name = "Erlang",
  type = LanguageType.ERLANG,
  ".erl",
)
