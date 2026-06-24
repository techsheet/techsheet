package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class QuarkusDetector : AbstractJvmFrameworkDetector(
  name = "Quarkus",
  framework = FrameworkType.QUARKUS,
  coordinates = listOf(
    Coordinate("io.quarkus"),
    Coordinate("io.quarkus.platform"),
  ),
  pluginIds = listOf("io.quarkus"),
)
