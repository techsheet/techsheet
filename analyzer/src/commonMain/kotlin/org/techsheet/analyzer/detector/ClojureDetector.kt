package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ClojureDetector : AbstractLanguageDetector(
  name = "Clojure",
  type = LanguageType.CLOJURE,
  ".clj", ".cljs",
)
