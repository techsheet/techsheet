package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ProjectReactorDetector : AbstractJvmFrameworkDetector(
  name = "Project Reactor",
  framework = FrameworkType.PROJECT_REACTOR,
  coordinates = listOf(Coordinate("io.projectreactor")),
)
