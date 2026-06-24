package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class HelidonDetector : AbstractJvmFrameworkDetector(
  name = "Helidon",
  framework = FrameworkType.HELIDON,
  coordinates = listOf(Coordinate("io.helidon")),
)
