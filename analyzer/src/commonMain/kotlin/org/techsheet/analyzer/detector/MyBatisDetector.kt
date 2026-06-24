package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class MyBatisDetector : AbstractJvmFrameworkDetector(
  name = "MyBatis",
  framework = FrameworkType.MYBATIS,
  coordinates = listOf(Coordinate("org.mybatis")),
)
