package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class AkkaHttpDetector : AbstractJvmDependencyDetector(
  name = "Akka HTTP",
  framework = FrameworkType.AKKA_HTTP,
  coordinates = listOf(
    Coordinate("com.typesafe.akka", "akka-http"),
    Coordinate("com.typesafe.akka", "akka-http-core"),
    Coordinate("com.typesafe.akka", "akka-http-spray-json"),
    Coordinate("com.typesafe.akka", "akka-http-jackson"),
    Coordinate("com.typesafe.akka", "akka-http-xml"),
    Coordinate("com.typesafe.akka", "akka-http-testkit"),
    Coordinate("com.lightbend.akka", "akka-http"),
    Coordinate("com.lightbend.akka", "akka-http-core"),
  ),
)
