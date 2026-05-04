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
  ASCIIDOC("asciidoc", "AsciiDoc"),
  SHELL("shell", "Shell"),
  PERL("perl", "Perl"),
  COBOL("cobol", "COBOL"),
  FORTRAN("fortran", "Fortran"),
  PASCAL("pascal", "Pascal"),
  VISUAL_BASIC("visual-basic", "Visual Basic"),
  ABAP("abap", "ABAP"),
  PLSQL("plsql", "PL/SQL"),
  LUA("lua", "Lua"),
  HASKELL("haskell", "Haskell"),
  ELIXIR("elixir", "Elixir"),
  ERLANG("erlang", "Erlang"),
  CLOJURE("clojure", "Clojure"),
  FSHARP("fsharp", "F#"),
  R("r", "R");

  override val type: String = "language"
}
