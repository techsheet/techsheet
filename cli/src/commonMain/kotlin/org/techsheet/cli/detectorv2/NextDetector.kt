package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class NextDetector : AbstractNpmDependencyDetector(
  name = "Next.js",
  packageName = "next",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.NEXT, version) },
)
