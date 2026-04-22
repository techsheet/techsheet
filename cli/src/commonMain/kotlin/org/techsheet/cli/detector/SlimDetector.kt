package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SlimDetector : AbstractPhpDependencyDetector(
  name = "Slim",
  framework = FrameworkType.SLIM,
  packageNames = listOf("slim/slim"),
)
