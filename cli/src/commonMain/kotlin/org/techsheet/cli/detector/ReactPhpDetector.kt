package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ReactPhpDetector : AbstractPhpDependencyDetector(
  name = "ReactPHP",
  framework = FrameworkType.REACTPHP,
  packageNames = listOf("react/event-loop"),
)
