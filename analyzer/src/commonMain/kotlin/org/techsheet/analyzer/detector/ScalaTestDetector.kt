package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ScalaTestDetector : AbstractJvmFrameworkDetector(
  name = "ScalaTest",
  framework = FrameworkType.SCALATEST,
  coordinates = listOf(
    Coordinate("org.scalatest"),
    Coordinate("org.scalactic"),
  ),
)
