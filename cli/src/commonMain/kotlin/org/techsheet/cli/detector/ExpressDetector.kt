package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ExpressDetector : AbstractNpmDependencyDetector(
  "Express", "express",
  { sheet, v -> sheet.withFramework(FrameworkType.EXPRESS, v) },
)
