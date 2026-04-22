package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class PhalconDetector : AbstractPhpDependencyDetector(
  name = "Phalcon",
  framework = FrameworkType.PHALCON,
  packageNames = listOf("phalcon/cphalcon"),
)
