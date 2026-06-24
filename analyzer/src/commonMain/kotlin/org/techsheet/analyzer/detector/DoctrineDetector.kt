package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class DoctrineDetector : AbstractPhpFrameworkDetector(
  name = "Doctrine",
  framework = FrameworkType.DOCTRINE,
  packageNames = listOf("doctrine/orm", "doctrine/dbal"),
)
