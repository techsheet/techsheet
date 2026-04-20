package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class SpringBootDetector : AbstractJvmDependencyDetector(
  name = "Spring Boot",
  framework = FrameworkType.SPRING_BOOT,
  coordinates = listOf(Coordinate("org.springframework.boot")),
  pluginIds = listOf("org.springframework.boot"),
)
