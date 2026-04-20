package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class ApacheCxfDetector : AbstractJvmDependencyDetector(
  name = "Apache CXF",
  framework = FrameworkType.APACHE_CXF,
  coordinates = listOf(Coordinate("org.apache.cxf")),
)
