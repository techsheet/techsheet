package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ArrowDetector : AbstractJvmFrameworkDetector(
  name = "Arrow",
  framework = FrameworkType.ARROW,
  coordinates = listOf(Coordinate("io.arrow-kt")),
)
