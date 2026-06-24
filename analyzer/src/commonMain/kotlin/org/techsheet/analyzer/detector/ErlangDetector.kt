package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ErlangDetector : AbstractLanguageDetector(
  name = "Erlang",
  type = LanguageType.ERLANG,
  ".erl",
)
