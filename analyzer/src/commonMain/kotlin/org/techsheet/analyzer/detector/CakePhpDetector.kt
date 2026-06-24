package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class CakePhpDetector : AbstractPhpFrameworkDetector(
  name = "CakePHP",
  framework = FrameworkType.CAKEPHP,
  packageNames = listOf("cakephp/cakephp"),
)
