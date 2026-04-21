package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SpockDetector : AbstractJvmDependencyDetector(
  name = "Spock",
  framework = FrameworkType.SPOCK,
  coordinates = listOf(Coordinate("org.spockframework")),
)
