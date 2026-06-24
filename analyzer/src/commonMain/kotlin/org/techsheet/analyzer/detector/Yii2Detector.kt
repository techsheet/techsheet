package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class Yii2Detector : AbstractPhpFrameworkDetector(
  name = "Yii2",
  framework = FrameworkType.YII2,
  packageNames = listOf("yiisoft/yii2"),
)
