package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ClojureDetector : AbstractSourceFileLanguageDetector(
  name = "Clojure",
  type = LanguageType.CLOJURE,
  ".clj", ".cljs",
)
