package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SymfonyDetector : AbstractPhpFrameworkDetector(
  name = "Symfony",
  framework = FrameworkType.SYMFONY,
  packageNames = listOf("symfony/framework-bundle", "symfony/symfony"),
)
