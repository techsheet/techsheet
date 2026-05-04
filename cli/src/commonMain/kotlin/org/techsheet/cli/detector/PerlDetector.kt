package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PerlDetector : AbstractSourceFileLanguageDetector(
  name = "Perl",
  type = LanguageType.PERL,
  ".pl", ".pm",
)
