package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class FlaskDetector : AbstractPythonDependencyDetector(
  name = "Flask",
  framework = FrameworkType.FLASK,
  packageName = "flask",
)
