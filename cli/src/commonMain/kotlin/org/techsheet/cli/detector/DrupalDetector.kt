package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class DrupalDetector : AbstractPhpFrameworkDetector(
  name = "Drupal",
  framework = FrameworkType.DRUPAL,
  packageNames = listOf("drupal/core", "drupal/core-recommended"),
)
