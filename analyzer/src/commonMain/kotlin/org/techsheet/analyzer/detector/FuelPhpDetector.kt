package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class FuelPhpDetector : AbstractPhpFrameworkDetector(
  name = "FuelPHP",
  framework = FrameworkType.FUELPHP,
  packageNames = listOf("fuel/fuel"),
)
