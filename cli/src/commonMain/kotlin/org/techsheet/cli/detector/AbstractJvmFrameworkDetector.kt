package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

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
  apply = { sheet: TechSheet, version: String? -> sheet.withFramework(framework, version) },
  coordinates = coordinates,
  pluginIds = pluginIds,
)
