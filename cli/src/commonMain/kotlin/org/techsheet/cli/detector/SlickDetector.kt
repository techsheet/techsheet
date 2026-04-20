package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SlickDetector : AbstractJvmDependencyDetector(
  name = "Slick",
  framework = FrameworkType.SLICK,
  coordinates = listOf(Coordinate("com.typesafe.slick")),
)
