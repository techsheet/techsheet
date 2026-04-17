package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ReactDetector : AbstractNpmDependencyDetector(
  "React", "react",
  { sheet, v -> sheet.withFramework(FrameworkType.REACT, v) },
)
