package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class EbeanDetector : AbstractJvmFrameworkDetector(
  name = "Ebean",
  framework = FrameworkType.EBEAN,
  coordinates = listOf(Coordinate("io.ebean")),
)
