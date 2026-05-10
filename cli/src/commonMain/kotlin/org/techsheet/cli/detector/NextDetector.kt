package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class NextDetector : AbstractNpmDependencyDetector(
  name = "Next.js",
  packageName = "next",
  apply = { result, version -> result.withFramework(FrameworkType.NEXT, version) },
)
