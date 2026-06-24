package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class TestNgDetector : AbstractJvmFrameworkDetector(
  name = "TestNG",
  framework = FrameworkType.TESTNG,
  coordinates = listOf(Coordinate("org.testng")),
)
