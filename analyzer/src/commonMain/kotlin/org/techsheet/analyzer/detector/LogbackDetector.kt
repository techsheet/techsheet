package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class LogbackDetector : AbstractJvmFrameworkDetector(
  name = "Logback",
  framework = FrameworkType.LOGBACK,
  coordinates = listOf(Coordinate("ch.qos.logback")),
)
