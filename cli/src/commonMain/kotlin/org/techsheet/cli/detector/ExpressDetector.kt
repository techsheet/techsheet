package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class ExpressDetector : AbstractNpmDependencyDetector(
  "Express", "express",
  { sheet, v -> sheet.withTechnology(TechnologyType.EXPRESS, v) },
)
