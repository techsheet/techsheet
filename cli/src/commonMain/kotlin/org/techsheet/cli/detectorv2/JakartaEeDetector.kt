package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class JakartaEeDetector : AbstractJvmDependencyDetector(
  name = "Jakarta EE",
  framework = FrameworkType.JAKARTA_EE,
  coordinates = listOf(
    Coordinate("jakarta.platform"),
    Coordinate("jakarta.servlet"),
    Coordinate("jakarta.ws.rs"),
    Coordinate("jakarta.enterprise"),
    Coordinate("jakarta.persistence"),
    Coordinate("javax", "javaee-api"),
    Coordinate("javax.servlet", "javax.servlet-api"),
  ),
)
