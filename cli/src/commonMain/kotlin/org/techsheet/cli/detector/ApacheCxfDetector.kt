package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ApacheCxfDetector : AbstractJvmFrameworkDetector(
  name = "Apache CXF",
  framework = FrameworkType.APACHE_CXF,
  coordinates = listOf(Coordinate("org.apache.cxf")),
)
