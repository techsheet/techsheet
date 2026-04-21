package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class KtorDetector : AbstractJvmDependencyDetector(
  name = "Ktor",
  framework = FrameworkType.KTOR,
  coordinates = listOf(Coordinate("io.ktor")),
  pluginIds = listOf("io.ktor.plugin"),
)
