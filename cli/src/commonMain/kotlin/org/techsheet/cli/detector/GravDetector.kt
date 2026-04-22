package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class GravDetector : AbstractPhpFrameworkDetector(
  name = "Grav",
  framework = FrameworkType.GRAV,
  packageNames = listOf("getgrav/grav"),
)
