package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class AngularDetector : AbstractNpmDependencyDetector(
  name = "Angular",
  packageName = "@angular/core",
  apply = { result, version -> result.withFramework(FrameworkType.ANGULAR, version) },
)
