package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class KtormDetector : AbstractJvmFrameworkDetector(
  name = "Ktorm",
  framework = FrameworkType.KTORM,
  coordinates = listOf(Coordinate("org.ktorm")),
)
