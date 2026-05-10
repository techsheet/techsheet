package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ExpressDetector : AbstractNpmDependencyDetector(
  name = "Express",
  packageName = "express",
  apply = { result, version -> result.withFramework(FrameworkType.EXPRESS, version) },
)
