package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class DjangoDetector : AbstractPythonDependencyDetector(
  name = "Django",
  framework = FrameworkType.DJANGO,
  packageName = "django",
)
