package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ContaoDetector : AbstractPhpFrameworkDetector(
  name = "Contao",
  framework = FrameworkType.CONTAO,
  packageNames = listOf("contao/core-bundle", "contao/manager-bundle"),
)
