package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class WireMockDetector : AbstractJvmFrameworkDetector(
  name = "WireMock",
  framework = FrameworkType.WIREMOCK,
  coordinates = listOf(
    Coordinate("org.wiremock"),
    Coordinate("com.github.tomakehurst", "wiremock"),
    Coordinate("com.github.tomakehurst", "wiremock-jre8"),
    Coordinate("com.github.tomakehurst", "wiremock-standalone"),
  ),
)
