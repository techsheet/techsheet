package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class DoctrineDetector : AbstractPhpFrameworkDetector(
  name = "Doctrine",
  framework = FrameworkType.DOCTRINE,
  packageNames = listOf("doctrine/orm", "doctrine/dbal"),
)
