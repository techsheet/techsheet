package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class SpringWebFluxDetector : AbstractJvmDependencyDetector(
  name = "Spring WebFlux",
  framework = FrameworkType.SPRING_WEBFLUX,
  coordinates = listOf(
    Coordinate("org.springframework.boot", "spring-boot-starter-webflux"),
    Coordinate("org.springframework", "spring-webflux"),
  ),
)
