package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class LumenDetector : AbstractPhpDependencyDetector(
  name = "Lumen",
  framework = FrameworkType.LUMEN,
  packageNames = listOf("laravel/lumen-framework"),
)
