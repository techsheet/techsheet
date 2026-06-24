package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class PhalconDetector : AbstractPhpFrameworkDetector(
  name = "Phalcon",
  framework = FrameworkType.PHALCON,
  packageNames = listOf("phalcon/cphalcon"),
)
