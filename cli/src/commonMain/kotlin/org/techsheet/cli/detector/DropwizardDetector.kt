package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class DropwizardDetector : AbstractJvmDependencyDetector(
  name = "Dropwizard",
  framework = FrameworkType.DROPWIZARD,
  coordinates = listOf(Coordinate("io.dropwizard")),
)
