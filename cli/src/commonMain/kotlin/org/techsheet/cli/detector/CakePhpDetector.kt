package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class CakePhpDetector : AbstractPhpFrameworkDetector(
  name = "CakePHP",
  framework = FrameworkType.CAKEPHP,
  packageNames = listOf("cakephp/cakephp"),
)
