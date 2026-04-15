package org.techsheet.cli.domain

data class BuildTool(
  val type: BuildToolType,
  val version: String?,
)

enum class BuildToolType(val title: String) {
  GRADLE("Gradle"),
  GRADLE_KOTLIN("Gradle - Kotlin DSL"),
  GRADLE_GROOVY("Gradle - Groovy DSL"),
  MAVEN("Maven"),
}
