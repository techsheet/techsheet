package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class FlaskDetector : AbstractPythonFrameworkDetector(
  name = "Flask",
  framework = FrameworkType.FLASK,
  packageName = "flask",
)
