package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class DoctrineDetector : AbstractPhpDependencyDetector(
  name = "Doctrine",
  framework = FrameworkType.DOCTRINE,
  packageNames = listOf("doctrine/orm", "doctrine/dbal"),
)
