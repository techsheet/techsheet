package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class DropwizardDetector : AbstractJvmFrameworkDetector(
  name = "Dropwizard",
  framework = FrameworkType.DROPWIZARD,
  coordinates = listOf(Coordinate("io.dropwizard")),
)
