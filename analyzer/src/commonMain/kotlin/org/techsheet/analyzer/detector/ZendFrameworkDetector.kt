package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ZendFrameworkDetector : AbstractPhpFrameworkDetector(
  name = "Zend Framework",
  framework = FrameworkType.ZEND_FRAMEWORK,
  packageNames = listOf("zendframework/zendframework"),
)
