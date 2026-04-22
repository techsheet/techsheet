package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class PhpUnitDetector : AbstractPhpFrameworkDetector(
  name = "PHPUnit",
  framework = FrameworkType.PHPUNIT,
  packageNames = listOf("phpunit/phpunit"),
)
