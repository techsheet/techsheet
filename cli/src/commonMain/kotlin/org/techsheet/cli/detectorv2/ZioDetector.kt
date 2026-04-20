package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class ZioDetector : AbstractJvmDependencyDetector(
  name = "ZIO",
  framework = FrameworkType.ZIO,
  coordinates = listOf(Coordinate("dev.zio")),
)
