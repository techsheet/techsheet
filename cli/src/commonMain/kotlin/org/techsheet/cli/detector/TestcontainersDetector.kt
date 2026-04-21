package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class TestcontainersDetector : AbstractJvmDependencyDetector(
  name = "Testcontainers",
  framework = FrameworkType.TESTCONTAINERS,
  coordinates = listOf(Coordinate("org.testcontainers")),
)
