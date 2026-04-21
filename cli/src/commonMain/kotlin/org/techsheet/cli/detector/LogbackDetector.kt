package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class LogbackDetector : AbstractJvmDependencyDetector(
  name = "Logback",
  framework = FrameworkType.LOGBACK,
  coordinates = listOf(Coordinate("ch.qos.logback")),
)
