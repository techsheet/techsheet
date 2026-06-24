package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class GravDetector : AbstractPhpFrameworkDetector(
  name = "Grav",
  framework = FrameworkType.GRAV,
  packageNames = listOf("getgrav/grav"),
)
