package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ZioDetector : AbstractJvmFrameworkDetector(
  name = "ZIO",
  framework = FrameworkType.ZIO,
  coordinates = listOf(Coordinate("dev.zio")),
)
