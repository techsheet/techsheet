package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ReactPhpDetector : AbstractPhpFrameworkDetector(
  name = "ReactPHP",
  framework = FrameworkType.REACTPHP,
  packageNames = listOf("react/event-loop"),
)
