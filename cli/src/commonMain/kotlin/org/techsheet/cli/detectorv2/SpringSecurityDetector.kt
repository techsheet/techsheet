package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class SpringSecurityDetector : AbstractJvmDependencyDetector(
  name = "Spring Security",
  framework = FrameworkType.SPRING_SECURITY,
  coordinates = listOf(
    Coordinate("org.springframework.boot", "spring-boot-starter-security"),
    // The whole `org.springframework.security` group is Spring Security's module family.
    Coordinate("org.springframework.security"),
  ),
)
