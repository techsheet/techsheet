package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class FlaskDetector : AbstractPythonFrameworkDetector(
  name = "Flask",
  framework = FrameworkType.FLASK,
  packageName = "flask",
)
