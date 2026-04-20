package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class ExposedDetector : AbstractJvmDependencyDetector(
  name = "Exposed",
  framework = FrameworkType.EXPOSED,
  coordinates = listOf(Coordinate("org.jetbrains.exposed")),
)
