package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class StrutsDetector : AbstractJvmFrameworkDetector(
  name = "Struts",
  framework = FrameworkType.STRUTS,
  coordinates = listOf(
    Coordinate("org.apache.struts"),
    Coordinate("struts", "struts"),
  ),
)
