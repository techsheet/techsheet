package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class RestAssuredDetector : AbstractJvmFrameworkDetector(
  name = "REST Assured",
  framework = FrameworkType.REST_ASSURED,
  coordinates = listOf(Coordinate("io.rest-assured")),
)
