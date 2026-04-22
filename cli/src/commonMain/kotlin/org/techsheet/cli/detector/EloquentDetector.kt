package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class EloquentDetector : AbstractPhpDependencyDetector(
  name = "Eloquent",
  framework = FrameworkType.ELOQUENT,
  packageNames = listOf("illuminate/database"),
)
