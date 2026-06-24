package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class PerlDetector : AbstractLanguageDetector(
  name = "Perl",
  type = LanguageType.PERL,
  ".pl", ".pm",
)
