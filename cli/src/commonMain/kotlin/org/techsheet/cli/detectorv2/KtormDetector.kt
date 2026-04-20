package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class KtormDetector : AbstractJvmDependencyDetector(
  name = "Ktorm",
  framework = FrameworkType.KTORM,
  coordinates = listOf(Coordinate("org.ktorm")),
)
