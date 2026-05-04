package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class OcamlDetector : AbstractSourceFileLanguageDetector(
  name = "OCaml",
  type = LanguageType.OCAML,
  ".ml", ".mli",
)
