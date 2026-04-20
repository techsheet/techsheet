package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class AngularDetector : AbstractNpmDependencyDetector(
  name = "Angular",
  packageName = "@angular/core",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.ANGULAR, version) },
)
