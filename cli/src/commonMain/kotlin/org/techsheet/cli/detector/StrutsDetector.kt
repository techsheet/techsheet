package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class StrutsDetector : AbstractJvmFrameworkDetector(
  name = "Struts",
  framework = FrameworkType.STRUTS,
  coordinates = listOf(
    Coordinate("org.apache.struts"),
    Coordinate("struts", "struts"),
  ),
)
