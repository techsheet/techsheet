package org.techsheet.cli.domain

data class Language(
  val type: LanguageType,
  val version: String?,
)

enum class LanguageType(
  override val key: String,
  override val title: String,
) : Technology {
  JAVA("java", "Java"),
  KOTLIN("kotlin", "Kotlin"),
  GROOVY("groovy", "Groovy"),
  SCALA("scala", "Scala"),
  JAVASCRIPT("javascript", "JavaScript"),
  TYPESCRIPT("typescript", "TypeScript"),
  PHP("php", "PHP"),
  PYTHON("python", "Python"),
  CPP("cpp", "C++"),
  CSHARP("csharp", "C#"),
  HTML("html", "HTML"),
  CSS("css", "CSS"),
  SCSS("scss", "SCSS/SASS"),
  MARKDOWN("markdown", "Markdown"),
  ASCIIDOC("asciidoc", "AsciiDoc");

  override val type: String = "language"
}
