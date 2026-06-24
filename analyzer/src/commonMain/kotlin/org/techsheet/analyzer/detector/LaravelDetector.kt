package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class LaravelDetector : AbstractPhpFrameworkDetector(
  name = "Laravel",
  framework = FrameworkType.LARAVEL,
  packageNames = listOf("laravel/framework"),
)
