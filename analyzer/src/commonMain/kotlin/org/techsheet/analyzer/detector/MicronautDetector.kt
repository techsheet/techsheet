package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class MicronautDetector : AbstractJvmFrameworkDetector(
  name = "Micronaut",
  framework = FrameworkType.MICRONAUT,
  coordinates = listOf(Coordinate("io.micronaut")),
  pluginIds = listOf(
    "io.micronaut.application",
    "io.micronaut.library",
    "io.micronaut.minimal.application",
    "io.micronaut.minimal.library",
  ),
)
