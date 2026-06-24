package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class TestcontainersDetector : AbstractJvmFrameworkDetector(
  name = "Testcontainers",
  framework = FrameworkType.TESTCONTAINERS,
  coordinates = listOf(Coordinate("org.testcontainers")),
)
