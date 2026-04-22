package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ExposedDetector : AbstractJvmFrameworkDetector(
  name = "Exposed",
  framework = FrameworkType.EXPOSED,
  coordinates = listOf(Coordinate("org.jetbrains.exposed")),
)
