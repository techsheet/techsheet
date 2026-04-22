package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class VertxDetector : AbstractJvmFrameworkDetector(
  name = "Vert.x",
  framework = FrameworkType.VERTX,
  coordinates = listOf(Coordinate("io.vertx")),
)
