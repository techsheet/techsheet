package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ApacheCxfDetector : AbstractJvmFrameworkDetector(
  name = "Apache CXF",
  framework = FrameworkType.APACHE_CXF,
  coordinates = listOf(Coordinate("org.apache.cxf")),
)
