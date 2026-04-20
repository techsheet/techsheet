package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class KotlinxCoroutinesDetector : AbstractJvmDependencyDetector(
  name = "Kotlinx Coroutines",
  framework = FrameworkType.KOTLINX_COROUTINES,
  coordinates = listOf(
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-core"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-android"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-reactive"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-rx2"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-rx3"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk9"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-javafx"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-swing"),
    Coordinate("org.jetbrains.kotlinx", "kotlinx-coroutines-test"),
  ),
)
