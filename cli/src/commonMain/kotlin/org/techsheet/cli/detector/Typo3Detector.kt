package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class Typo3Detector : AbstractPhpFrameworkDetector(
  name = "TYPO3",
  framework = FrameworkType.TYPO3,
  packageNames = listOf("typo3/cms-core"),
)
