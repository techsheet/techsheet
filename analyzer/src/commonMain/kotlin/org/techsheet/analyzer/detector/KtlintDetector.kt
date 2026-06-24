package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.ToolType

class KtlintDetector : AbstractJvmDependencyDetector(
  name = "ktlint",
  apply = { result, version -> result.withTool(ToolType.KTLINT, version) },
  coordinates = listOf(
    Coordinate("com.pinterest", "ktlint"),
    Coordinate("com.pinterest.ktlint"),
  ),
  pluginIds = listOf("org.jlleitschuh.gradle.ktlint"),
)
