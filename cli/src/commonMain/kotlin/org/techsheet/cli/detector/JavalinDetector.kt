package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class JavalinDetector : AbstractJvmFrameworkDetector(
  name = "Javalin",
  framework = FrameworkType.JAVALIN,
  coordinates = listOf(Coordinate("io.javalin")),
)
