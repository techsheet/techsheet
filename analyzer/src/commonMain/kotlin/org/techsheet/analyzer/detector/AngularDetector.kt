package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class AngularDetector : AbstractNpmDependencyDetector(
  name = "Angular",
  packageName = "@angular/core",
  apply = { result, version -> result.withFramework(FrameworkType.ANGULAR, version) },
)
