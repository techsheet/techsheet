package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class HelidonDetector : AbstractJvmDependencyDetector(
  name = "Helidon",
  framework = FrameworkType.HELIDON,
  coordinates = listOf(Coordinate("io.helidon")),
)
