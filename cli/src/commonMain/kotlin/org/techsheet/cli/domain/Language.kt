package org.techsheet.cli.domain

data class Language(
  val type: LanguageType,
  val version: String?,
)

enum class LanguageType(val title: String) {
  JAVA("Java"),
  KOTLIN("Kotlin"),
  SCALA("Scala"),
  JAVASCRIPT("JavaScript"),
  TYPESCRIPT("TypeScript"),
  PHP("PHP"),
  PYTHON("Python"),
}
