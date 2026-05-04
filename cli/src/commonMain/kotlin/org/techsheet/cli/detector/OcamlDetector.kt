package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class OcamlDetector : AbstractLanguageDetector(
  name = "OCaml",
  type = LanguageType.OCAML,
  ".ml", ".mli",
)
