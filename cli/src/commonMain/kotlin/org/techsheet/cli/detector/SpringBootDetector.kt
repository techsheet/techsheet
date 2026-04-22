package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SpringBootDetector : AbstractJvmFrameworkDetector(
  name = "Spring Boot",
  framework = FrameworkType.SPRING_BOOT,
  coordinates = listOf(Coordinate("org.springframework.boot")),
  pluginIds = listOf("org.springframework.boot"),
)
