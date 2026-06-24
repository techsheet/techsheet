package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class JavalinDetector : AbstractJvmFrameworkDetector(
  name = "Javalin",
  framework = FrameworkType.JAVALIN,
  coordinates = listOf(Coordinate("io.javalin")),
)
