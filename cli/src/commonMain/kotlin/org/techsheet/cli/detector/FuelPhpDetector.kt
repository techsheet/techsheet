package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class FuelPhpDetector : AbstractPhpDependencyDetector(
  name = "FuelPHP",
  framework = FrameworkType.FUELPHP,
  packageNames = listOf("fuel/fuel"),
)
