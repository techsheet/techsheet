package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class RestAssuredDetector : AbstractJvmFrameworkDetector(
  name = "REST Assured",
  framework = FrameworkType.REST_ASSURED,
  coordinates = listOf(Coordinate("io.rest-assured")),
)
