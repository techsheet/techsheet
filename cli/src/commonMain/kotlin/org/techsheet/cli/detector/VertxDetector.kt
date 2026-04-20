package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class VertxDetector : AbstractJvmDependencyDetector(
  name = "Vert.x",
  framework = FrameworkType.VERTX,
  coordinates = listOf(Coordinate("io.vertx")),
)
