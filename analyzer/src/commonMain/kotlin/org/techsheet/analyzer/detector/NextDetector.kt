package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class NextDetector : AbstractNpmDependencyDetector(
  name = "Next.js",
  packageName = "next",
  apply = { result, version -> result.withFramework(FrameworkType.NEXT, version) },
)
