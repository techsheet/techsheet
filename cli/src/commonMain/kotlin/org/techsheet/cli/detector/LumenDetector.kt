package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class LumenDetector : AbstractPhpFrameworkDetector(
  name = "Lumen",
  framework = FrameworkType.LUMEN,
  packageNames = listOf("laravel/lumen-framework"),
)
