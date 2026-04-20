package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class JavalinDetector : AbstractJvmDependencyDetector(
  name = "Javalin",
  framework = FrameworkType.JAVALIN,
  coordinates = listOf(Coordinate("io.javalin")),
)
