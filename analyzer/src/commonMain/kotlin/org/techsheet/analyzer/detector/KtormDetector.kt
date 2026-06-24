package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class KtormDetector : AbstractJvmFrameworkDetector(
  name = "Ktorm",
  framework = FrameworkType.KTORM,
  coordinates = listOf(Coordinate("org.ktorm")),
)
