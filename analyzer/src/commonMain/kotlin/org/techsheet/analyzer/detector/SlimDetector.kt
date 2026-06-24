package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SlimDetector : AbstractPhpFrameworkDetector(
  name = "Slim",
  framework = FrameworkType.SLIM,
  packageNames = listOf("slim/slim"),
)
