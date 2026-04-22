package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class FastApiDetector : AbstractPythonFrameworkDetector(
  name = "FastAPI",
  framework = FrameworkType.FASTAPI,
  packageName = "fastapi",
)
