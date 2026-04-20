package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class KotestDetector : AbstractJvmDependencyDetector(
  name = "Kotest",
  framework = FrameworkType.KOTEST,
  coordinates = listOf(Coordinate("io.kotest")),
)
