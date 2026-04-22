package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SlickDetector : AbstractJvmFrameworkDetector(
  name = "Slick",
  framework = FrameworkType.SLICK,
  coordinates = listOf(Coordinate("com.typesafe.slick")),
)
