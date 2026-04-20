package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class MockitoDetector : AbstractJvmDependencyDetector(
  name = "Mockito",
  framework = FrameworkType.MOCKITO,
  coordinates = listOf(
    Coordinate("org.mockito"),
    Coordinate("org.mockito.kotlin"),
  ),
)
