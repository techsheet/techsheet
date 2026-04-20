package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ProjectReactorDetector : AbstractJvmDependencyDetector(
  name = "Project Reactor",
  framework = FrameworkType.PROJECT_REACTOR,
  coordinates = listOf(Coordinate("io.projectreactor")),
)
