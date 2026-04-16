package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class ReactDetector : AbstractNpmDependencyDetector(
  "React", "react",
  { sheet, v -> sheet.withTechnology(TechnologyType.REACT, v) },
)
