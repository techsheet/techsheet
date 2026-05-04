package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ClojureDetector : AbstractLanguageDetector(
  name = "Clojure",
  type = LanguageType.CLOJURE,
  ".clj", ".cljs",
)
