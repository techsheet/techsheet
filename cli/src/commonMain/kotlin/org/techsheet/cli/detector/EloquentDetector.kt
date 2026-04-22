package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class EloquentDetector : AbstractPhpFrameworkDetector(
  name = "Eloquent",
  framework = FrameworkType.ELOQUENT,
  packageNames = listOf("illuminate/database"),
)
