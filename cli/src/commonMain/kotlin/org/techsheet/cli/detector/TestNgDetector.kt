package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class TestNgDetector : AbstractJvmDependencyDetector(
  name = "TestNG",
  framework = FrameworkType.TESTNG,
  coordinates = listOf(Coordinate("org.testng")),
)
