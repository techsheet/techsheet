package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class FastApiDetector : AbstractPythonDependencyDetector(
  name = "FastAPI",
  technology = TechnologyType.FASTAPI,
  packageName = "fastapi",
)
