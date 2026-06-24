package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class JUnitDetector : AbstractJvmFrameworkDetector(
  name = "JUnit",
  framework = FrameworkType.JUNIT,
  coordinates = listOf(
    Coordinate("junit", "junit"),
    Coordinate("org.junit.jupiter"),
    Coordinate("org.junit.platform"),
    Coordinate("org.junit.vintage"),
    Coordinate("org.junit", "junit-bom"),
    Coordinate("org.jetbrains.kotlin", "kotlin-test-junit"),
    Coordinate("org.jetbrains.kotlin", "kotlin-test-junit5"),
  ),
)
