package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class DrupalDetector : AbstractPhpFrameworkDetector(
  name = "Drupal",
  framework = FrameworkType.DRUPAL,
  packageNames = listOf("drupal/core", "drupal/core-recommended"),
)
