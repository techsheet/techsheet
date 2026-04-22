package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class LaravelDetector : AbstractPhpDependencyDetector(
  name = "Laravel",
  framework = FrameworkType.LARAVEL,
  packageNames = listOf("laravel/framework"),
)
