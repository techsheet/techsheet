package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class CakePhpDetector : AbstractPhpDependencyDetector(
  name = "CakePHP",
  framework = FrameworkType.CAKEPHP,
  packageNames = listOf("cakephp/cakephp"),
)
