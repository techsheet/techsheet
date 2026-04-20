package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class DjangoDetector : AbstractPythonDependencyDetector(
  name = "Django",
  framework = FrameworkType.DJANGO,
  packageName = "django",
)
