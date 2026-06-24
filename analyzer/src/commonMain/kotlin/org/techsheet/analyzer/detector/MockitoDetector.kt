package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class MockitoDetector : AbstractJvmFrameworkDetector(
  name = "Mockito",
  framework = FrameworkType.MOCKITO,
  coordinates = listOf(
    Coordinate("org.mockito"),
    Coordinate("org.mockito.kotlin"),
  ),
)
