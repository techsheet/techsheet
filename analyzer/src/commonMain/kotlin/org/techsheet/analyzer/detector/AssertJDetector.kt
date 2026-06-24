package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class AssertJDetector : AbstractJvmFrameworkDetector(
  name = "AssertJ",
  framework = FrameworkType.ASSERTJ,
  coordinates = listOf(Coordinate("org.assertj")),
)
