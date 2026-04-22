package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class Yii2Detector : AbstractPhpFrameworkDetector(
  name = "Yii2",
  framework = FrameworkType.YII2,
  packageNames = listOf("yiisoft/yii2"),
)
