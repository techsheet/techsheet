package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PerlDetector : AbstractLanguageDetector(
  name = "Perl",
  type = LanguageType.PERL,
  ".pl", ".pm",
)
