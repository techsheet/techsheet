package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class EloquentDetector : AbstractPhpFrameworkDetector(
  name = "Eloquent",
  framework = FrameworkType.ELOQUENT,
  packageNames = listOf("illuminate/database"),
)
