package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ExposedDetector : AbstractJvmFrameworkDetector(
  name = "Exposed",
  framework = FrameworkType.EXPOSED,
  coordinates = listOf(Coordinate("org.jetbrains.exposed")),
)
