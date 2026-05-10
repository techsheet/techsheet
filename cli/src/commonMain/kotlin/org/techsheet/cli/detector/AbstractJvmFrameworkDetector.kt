package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.DetectionResult

/**
 * JVM dependency detector specialised for [org.techsheet.cli.domain.FrameworkType]
 */
abstract class AbstractJvmFrameworkDetector(
  name: String,
  framework: FrameworkType,
  coordinates: List<Coordinate>,
  pluginIds: List<String> = emptyList(),
) : AbstractJvmDependencyDetector(
  name = name,
  apply = { result: DetectionResult, version: String? -> result.withFramework(framework, version) },
  coordinates = coordinates,
  pluginIds = pluginIds,
)
