package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class DetektDetector : AbstractJvmDependencyDetector(
  name = "Detekt",
  apply = { result, version -> result.withTool(ToolType.DETEKT, version) },
  coordinates = listOf(Coordinate("io.gitlab.arturbosch.detekt")),
  pluginIds = listOf("io.gitlab.arturbosch.detekt"),
)
