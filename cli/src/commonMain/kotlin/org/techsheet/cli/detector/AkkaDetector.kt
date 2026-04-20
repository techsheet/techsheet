package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class AkkaDetector : AbstractJvmDependencyDetector(
  name = "Akka",
  framework = FrameworkType.AKKA,
  coordinates = listOf(
    Coordinate("com.typesafe.akka"),
    Coordinate("com.lightbend.akka"),
  ),
)
