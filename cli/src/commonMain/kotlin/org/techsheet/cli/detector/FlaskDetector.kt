package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class FlaskDetector : AbstractPythonDependencyDetector(
  name = "Flask",
  technology = TechnologyType.FLASK,
  packageName = "flask",
)
