package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class Log4j2Detector : AbstractJvmDependencyDetector(
  name = "Log4j2",
  framework = FrameworkType.LOG4J2,
  coordinates = listOf(Coordinate("org.apache.logging.log4j")),
)
