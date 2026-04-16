package org.techsheet.cli.domain

data class Tool(
  val type: ToolType,
  val version: String?,
)

enum class ToolType(val title: String, val category: ToolCategory) {

  // Build Tools
  GRADLE("Gradle", ToolCategory.BUILD),
  GRADLE_KOTLIN("Gradle - Kotlin DSL", ToolCategory.BUILD),
  GRADLE_GROOVY("Gradle - Groovy DSL", ToolCategory.BUILD),
  MAVEN("Maven", ToolCategory.BUILD),
  NPM("NPM", ToolCategory.BUILD),
  YARN("Yarn", ToolCategory.BUILD),
  SBT("sbt", ToolCategory.BUILD),

  // CI Tools
  GITLAB_CI("GitLab CI", ToolCategory.CI),
  GITHUB_ACTIONS("GitHub Actions", ToolCategory.CI),
  CODEOWNERS("CODEOWNERS", ToolCategory.CI),

  // Container
  DOCKER("Docker", ToolCategory.CONTAINER),
  DOCKER_COMPOSE("Docker Compose", ToolCategory.CONTAINER),

  // Developer tooling
  EDITORCONFIG("EditorConfig", ToolCategory.DEV),
  RENOVATE("Renovate", ToolCategory.DEV),
  GIT("Git", ToolCategory.DEV),
  NODE("Node.js", ToolCategory.DEV),

  // IDEs
  INTELLIJ_IDEA("IntelliJ IDEA", ToolCategory.IDE),
  VS_CODE("Visual Studio Code", ToolCategory.IDE),
}

enum class ToolCategory(val title: String) {
  BUILD("Build"),
  CI("CI"),
  CONTAINER("Container"),
  DEV("Development"),
  IDE("IDE"),
}
