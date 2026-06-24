package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class AkkaDetector : AbstractJvmFrameworkDetector(
  name = "Akka",
  framework = FrameworkType.AKKA,
  coordinates = listOf(
    Coordinate("com.typesafe.akka"),
    Coordinate("com.lightbend.akka"),
  ),
)
