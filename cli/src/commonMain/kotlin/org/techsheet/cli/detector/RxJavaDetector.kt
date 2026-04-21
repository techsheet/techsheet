package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class RxJavaDetector : AbstractJvmDependencyDetector(
  name = "RxJava",
  framework = FrameworkType.RXJAVA,
  coordinates = listOf(
    Coordinate("io.reactivex.rxjava2"),
    Coordinate("io.reactivex.rxjava3"),
  ),
)
