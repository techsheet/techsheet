package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ArrowDetector : AbstractJvmDependencyDetector(
  name = "Arrow",
  framework = FrameworkType.ARROW,
  coordinates = listOf(Coordinate("io.arrow-kt")),
)
