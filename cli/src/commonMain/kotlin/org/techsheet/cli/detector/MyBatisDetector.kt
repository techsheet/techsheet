package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class MyBatisDetector : AbstractJvmDependencyDetector(
  name = "MyBatis",
  framework = FrameworkType.MYBATIS,
  coordinates = listOf(Coordinate("org.mybatis")),
)
