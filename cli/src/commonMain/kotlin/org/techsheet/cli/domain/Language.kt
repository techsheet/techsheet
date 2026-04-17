package org.techsheet.cli.domain

data class Language(
  val type: LanguageType,
  val version: String?,
)

enum class LanguageType(
  val title: String,
  val url: String
) {
  JAVA("Java", "https://techsheet.org/language/java"),
  KOTLIN("Kotlin", "https://techsheet.org/language/kotlin"),
  SCALA("Scala", "https://techsheet.org/language/scala"),
  JAVASCRIPT("JavaScript", "https://techsheet.org/language/javascript"),
  TYPESCRIPT("TypeScript", "https://techsheet.org/language/typescript"),
  PHP("PHP", "https://techsheet.org/language/php"),
  PYTHON("Python", "https://techsheet.org/language/python"),
  CPP("C++", "https://techsheet.org/language/cpp"),
  CSHARP("C#", "https://techsheet.org/language/csharp"),
}
