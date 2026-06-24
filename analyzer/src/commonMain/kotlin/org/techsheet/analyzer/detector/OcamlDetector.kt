package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class OcamlDetector : AbstractLanguageDetector(
  name = "OCaml",
  type = LanguageType.OCAML,
  ".ml", ".mli",
)
