package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class Http4sDetector : AbstractJvmDependencyDetector(
  name = "http4s",
  framework = FrameworkType.HTTP4S,
  coordinates = listOf(Coordinate("org.http4s")),
)
