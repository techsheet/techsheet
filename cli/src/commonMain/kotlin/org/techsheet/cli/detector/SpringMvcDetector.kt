package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SpringMvcDetector : AbstractJvmFrameworkDetector(
  name = "Spring MVC",
  framework = FrameworkType.SPRING_MVC,
  // Boot 4+ renamed the starter to `-webmvc`; Boot ≤3 ships MVC under the bare `-web` name;
  // plain Spring projects depend on `spring-webmvc` directly.
  coordinates = listOf(
    Coordinate("org.springframework.boot", "spring-boot-starter-webmvc"),
    Coordinate("org.springframework.boot", "spring-boot-starter-web"),
    Coordinate("org.springframework", "spring-webmvc"),
  ),
)
