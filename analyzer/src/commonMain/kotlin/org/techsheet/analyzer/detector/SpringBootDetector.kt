package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SpringBootDetector : AbstractJvmFrameworkDetector(
  name = "Spring Boot",
  framework = FrameworkType.SPRING_BOOT,
  coordinates = listOf(Coordinate("org.springframework.boot")),
  pluginIds = listOf("org.springframework.boot"),
)
