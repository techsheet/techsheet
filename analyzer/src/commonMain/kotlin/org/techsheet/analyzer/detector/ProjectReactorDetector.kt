package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ProjectReactorDetector : AbstractJvmFrameworkDetector(
  name = "Project Reactor",
  framework = FrameworkType.PROJECT_REACTOR,
  coordinates = listOf(Coordinate("io.projectreactor")),
)
