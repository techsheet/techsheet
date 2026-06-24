package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.FrameworkType

/**
 * JVM dependency detector specialised for [FrameworkType]
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
