package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ReactDetector : AbstractNpmDependencyDetector(
  name = "React",
  packageName = "react",
  apply = { result, version -> result.withFramework(FrameworkType.REACT, version) },
)
