package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class DjangoDetector : AbstractPythonFrameworkDetector(
  name = "Django",
  framework = FrameworkType.DJANGO,
  packageName = "django",
)
