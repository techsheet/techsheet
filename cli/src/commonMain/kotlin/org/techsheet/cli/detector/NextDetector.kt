package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class NextDetector : AbstractNpmDependencyDetector(
  "Next.js", "next",
  { sheet, v -> sheet.withFramework(FrameworkType.NEXT, v) },
)
