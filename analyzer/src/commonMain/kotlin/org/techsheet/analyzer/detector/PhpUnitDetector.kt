package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class PhpUnitDetector : AbstractPhpFrameworkDetector(
  name = "PHPUnit",
  framework = FrameworkType.PHPUNIT,
  packageNames = listOf("phpunit/phpunit"),
)
