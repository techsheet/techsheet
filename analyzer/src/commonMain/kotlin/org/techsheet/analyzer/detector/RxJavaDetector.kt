package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class RxJavaDetector : AbstractJvmFrameworkDetector(
  name = "RxJava",
  framework = FrameworkType.RXJAVA,
  coordinates = listOf(
    Coordinate("io.reactivex.rxjava2"),
    Coordinate("io.reactivex.rxjava3"),
  ),
)
