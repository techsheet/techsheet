package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class PlayDetector : AbstractJvmFrameworkDetector(
  name = "Play Framework",
  framework = FrameworkType.PLAY_FRAMEWORK,
  // Play 3.x+ lives under `org.playframework`; Play 2.x used `com.typesafe.play`.
  // `sbt-plugin` is how Play registers itself in `plugins.sbt`; `play-java`/`play-scala`
  // catch the library-only Maven/Gradle use case.
  coordinates = listOf(
    Coordinate("org.playframework", "sbt-plugin"),
    Coordinate("com.typesafe.play", "sbt-plugin"),
    Coordinate("org.playframework"),
    Coordinate("com.typesafe.play"),
  ),
)
