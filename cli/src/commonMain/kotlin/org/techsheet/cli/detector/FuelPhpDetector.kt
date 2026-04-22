package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class FuelPhpDetector : AbstractPhpFrameworkDetector(
  name = "FuelPHP",
  framework = FrameworkType.FUELPHP,
  packageNames = listOf("fuel/fuel"),
)
