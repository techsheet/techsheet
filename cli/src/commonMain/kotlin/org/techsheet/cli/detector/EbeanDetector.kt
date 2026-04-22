package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class EbeanDetector : AbstractJvmFrameworkDetector(
  name = "Ebean",
  framework = FrameworkType.EBEAN,
  coordinates = listOf(Coordinate("io.ebean")),
)
