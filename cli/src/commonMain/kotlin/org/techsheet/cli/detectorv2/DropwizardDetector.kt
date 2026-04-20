package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class DropwizardDetector : AbstractJvmDependencyDetector(
  name = "Dropwizard",
  framework = FrameworkType.DROPWIZARD,
  coordinates = listOf(Coordinate("io.dropwizard")),
)
