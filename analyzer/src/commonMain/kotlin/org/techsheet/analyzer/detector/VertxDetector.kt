package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class VertxDetector : AbstractJvmFrameworkDetector(
  name = "Vert.x",
  framework = FrameworkType.VERTX,
  coordinates = listOf(Coordinate("io.vertx")),
)
