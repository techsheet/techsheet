package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class NextDetector : AbstractNpmDependencyDetector(
  "Next.js", "next",
  { sheet, v -> sheet.withTechnology(TechnologyType.NEXT, v) },
)
