package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ReactDetector : AbstractNpmDependencyDetector(
  name = "React",
  packageName = "react",
  apply = { result, version -> result.withFramework(FrameworkType.REACT, version) },
)
