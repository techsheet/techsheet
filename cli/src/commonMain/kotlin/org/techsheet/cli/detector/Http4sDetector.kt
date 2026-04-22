package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class Http4sDetector : AbstractJvmFrameworkDetector(
  name = "http4s",
  framework = FrameworkType.HTTP4S,
  coordinates = listOf(Coordinate("org.http4s")),
)
