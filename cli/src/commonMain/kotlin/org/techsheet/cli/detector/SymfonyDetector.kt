package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SymfonyDetector : AbstractPhpFrameworkDetector(
  name = "Symfony",
  framework = FrameworkType.SYMFONY,
  packageNames = listOf("symfony/framework-bundle", "symfony/symfony"),
)
