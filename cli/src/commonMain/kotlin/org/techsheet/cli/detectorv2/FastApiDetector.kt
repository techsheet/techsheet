package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class FastApiDetector : AbstractPythonDependencyDetector(
  name = "FastAPI",
  framework = FrameworkType.FASTAPI,
  packageName = "fastapi",
)
