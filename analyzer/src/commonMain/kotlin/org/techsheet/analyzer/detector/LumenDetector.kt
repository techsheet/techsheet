package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class LumenDetector : AbstractPhpFrameworkDetector(
  name = "Lumen",
  framework = FrameworkType.LUMEN,
  packageNames = listOf("laravel/lumen-framework"),
)
