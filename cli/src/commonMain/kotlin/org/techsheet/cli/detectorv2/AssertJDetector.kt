package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class AssertJDetector : AbstractJvmDependencyDetector(
  name = "AssertJ",
  framework = FrameworkType.ASSERTJ,
  coordinates = listOf(Coordinate("org.assertj")),
)
