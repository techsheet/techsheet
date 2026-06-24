package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ExpressDetector : AbstractNpmDependencyDetector(
  name = "Express",
  packageName = "express",
  apply = { result, version -> result.withFramework(FrameworkType.EXPRESS, version) },
)
