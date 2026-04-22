package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class MockitoDetector : AbstractJvmFrameworkDetector(
  name = "Mockito",
  framework = FrameworkType.MOCKITO,
  coordinates = listOf(
    Coordinate("org.mockito"),
    Coordinate("org.mockito.kotlin"),
  ),
)
