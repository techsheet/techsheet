package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class RestAssuredDetector : AbstractJvmDependencyDetector(
  name = "REST Assured",
  framework = FrameworkType.REST_ASSURED,
  coordinates = listOf(Coordinate("io.rest-assured")),
)
