package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ReactDetector : AbstractNpmDependencyDetector(
  name = "React",
  packageName = "react",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.REACT, version) },
)
