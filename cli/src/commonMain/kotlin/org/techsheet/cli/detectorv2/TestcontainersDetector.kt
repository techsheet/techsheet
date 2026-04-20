package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class TestcontainersDetector : AbstractJvmDependencyDetector(
  name = "Testcontainers",
  framework = FrameworkType.TESTCONTAINERS,
  coordinates = listOf(Coordinate("org.testcontainers")),
)
