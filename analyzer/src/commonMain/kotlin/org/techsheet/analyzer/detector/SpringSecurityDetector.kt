package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SpringSecurityDetector : AbstractJvmFrameworkDetector(
  name = "Spring Security",
  framework = FrameworkType.SPRING_SECURITY,
  coordinates = listOf(
    Coordinate("org.springframework.boot", "spring-boot-starter-security"),
    // The whole `org.springframework.security` group is Spring Security's module family.
    Coordinate("org.springframework.security"),
  ),
)
