package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ExpressDetector : AbstractNpmDependencyDetector(
  name = "Express",
  packageName = "express",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.EXPRESS, version) },
)
