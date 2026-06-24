package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SpockDetector : AbstractJvmFrameworkDetector(
  name = "Spock",
  framework = FrameworkType.SPOCK,
  coordinates = listOf(Coordinate("org.spockframework")),
)
