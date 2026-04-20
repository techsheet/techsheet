package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class Slf4jDetector : AbstractJvmDependencyDetector(
  name = "SLF4J",
  framework = FrameworkType.SLF4J,
  coordinates = listOf(Coordinate("org.slf4j")),
)
