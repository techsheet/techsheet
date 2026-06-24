package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class KotestDetector : AbstractJvmFrameworkDetector(
  name = "Kotest",
  framework = FrameworkType.KOTEST,
  coordinates = listOf(Coordinate("io.kotest")),
)
