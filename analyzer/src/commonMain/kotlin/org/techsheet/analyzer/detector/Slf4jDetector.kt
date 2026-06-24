package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class Slf4jDetector : AbstractJvmFrameworkDetector(
  name = "SLF4J",
  framework = FrameworkType.SLF4J,
  coordinates = listOf(Coordinate("org.slf4j")),
)
