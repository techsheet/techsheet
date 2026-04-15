package org.techsheet.cli.domain

data class ProgrammingLanguage(
  val type: ProgrammingLanguageType,
  val version: String?,
)

enum class ProgrammingLanguageType(val title: String) {
  JAVA("Java"),
  KOTLIN("Kotlin"),
  Scala("Scala"),
  JAVASCRIPT("JavaScript"),
  TYPESCRIPT("TypeScript"),
  PHP("PHP"),
  PYTHON("Python"),
}
