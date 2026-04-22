package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class LaravelDetector : AbstractPhpFrameworkDetector(
  name = "Laravel",
  framework = FrameworkType.LARAVEL,
  packageNames = listOf("laravel/framework"),
)
