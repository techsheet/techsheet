package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class MonologDetector : AbstractPhpFrameworkDetector(
  name = "Monolog",
  framework = FrameworkType.MONOLOG,
  packageNames = listOf("monolog/monolog"),
)
