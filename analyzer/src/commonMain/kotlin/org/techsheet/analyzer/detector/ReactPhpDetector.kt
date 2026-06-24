package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ReactPhpDetector : AbstractPhpFrameworkDetector(
  name = "ReactPHP",
  framework = FrameworkType.REACTPHP,
  packageNames = listOf("react/event-loop"),
)
