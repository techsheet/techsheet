package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ScalaTestDetector : AbstractJvmFrameworkDetector(
  name = "ScalaTest",
  framework = FrameworkType.SCALATEST,
  coordinates = listOf(
    Coordinate("org.scalatest"),
    Coordinate("org.scalactic"),
  ),
)
