package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class DjangoDetector : AbstractPythonFrameworkDetector(
  name = "Django",
  framework = FrameworkType.DJANGO,
  packageName = "django",
)
