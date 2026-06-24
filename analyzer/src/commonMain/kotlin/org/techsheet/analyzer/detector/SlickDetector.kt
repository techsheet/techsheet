package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SlickDetector : AbstractJvmFrameworkDetector(
  name = "Slick",
  framework = FrameworkType.SLICK,
  coordinates = listOf(Coordinate("com.typesafe.slick")),
)
