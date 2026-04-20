package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class CatsEffectDetector : AbstractJvmDependencyDetector(
  name = "Cats Effect",
  framework = FrameworkType.CATS_EFFECT,
  coordinates = listOf(
    Coordinate("org.typelevel", "cats-effect"),
    Coordinate("org.typelevel", "cats-effect-core"),
    Coordinate("org.typelevel", "cats-effect-kernel"),
    Coordinate("org.typelevel", "cats-effect-std"),
  ),
)
