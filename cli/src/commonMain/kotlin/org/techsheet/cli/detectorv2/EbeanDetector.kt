package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class EbeanDetector : AbstractJvmDependencyDetector(
  name = "Ebean",
  framework = FrameworkType.EBEAN,
  coordinates = listOf(Coordinate("io.ebean")),
)
