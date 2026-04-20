package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class WireMockDetector : AbstractJvmDependencyDetector(
  name = "WireMock",
  framework = FrameworkType.WIREMOCK,
  coordinates = listOf(
    Coordinate("org.wiremock"),
    Coordinate("com.github.tomakehurst", "wiremock"),
    Coordinate("com.github.tomakehurst", "wiremock-jre8"),
    Coordinate("com.github.tomakehurst", "wiremock-standalone"),
  ),
)
