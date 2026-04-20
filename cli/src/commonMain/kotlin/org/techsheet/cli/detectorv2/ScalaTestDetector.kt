package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class ScalaTestDetector : AbstractJvmDependencyDetector(
  name = "ScalaTest",
  framework = FrameworkType.SCALATEST,
  coordinates = listOf(
    Coordinate("org.scalatest"),
    Coordinate("org.scalactic"),
  ),
)
