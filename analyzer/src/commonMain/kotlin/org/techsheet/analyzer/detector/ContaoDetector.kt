package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ContaoDetector : AbstractPhpFrameworkDetector(
  name = "Contao",
  framework = FrameworkType.CONTAO,
  packageNames = listOf("contao/core-bundle", "contao/manager-bundle"),
)
