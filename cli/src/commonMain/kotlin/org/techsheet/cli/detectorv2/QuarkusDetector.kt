package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class QuarkusDetector : AbstractJvmDependencyDetector(
  name = "Quarkus",
  framework = FrameworkType.QUARKUS,
  coordinates = listOf(
    Coordinate("io.quarkus"),
    Coordinate("io.quarkus.platform"),
  ),
  pluginIds = listOf("io.quarkus"),
)
