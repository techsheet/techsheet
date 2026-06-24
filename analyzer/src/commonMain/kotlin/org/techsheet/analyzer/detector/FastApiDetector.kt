package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class FastApiDetector : AbstractPythonFrameworkDetector(
  name = "FastAPI",
  framework = FrameworkType.FASTAPI,
  packageName = "fastapi",
)
