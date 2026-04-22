package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ZendFrameworkDetector : AbstractPhpFrameworkDetector(
  name = "Zend Framework",
  framework = FrameworkType.ZEND_FRAMEWORK,
  packageNames = listOf("zendframework/zendframework"),
)
