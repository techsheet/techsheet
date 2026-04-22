package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class MonologDetector : AbstractPhpDependencyDetector(
  name = "Monolog",
  framework = FrameworkType.MONOLOG,
  packageNames = listOf("monolog/monolog"),
)
