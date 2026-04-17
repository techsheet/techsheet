package org.techsheet.cli.domain

data class Tool(
  val type: ToolType,
  val version: String?,
)

enum class ToolType(val title: String, val category: ToolCategory) {

  // Build
  GRADLE("Gradle", ToolCategory.BUILD),
  GRADLE_KOTLIN("Gradle - Kotlin DSL", ToolCategory.BUILD),
  GRADLE_GROOVY("Gradle - Groovy DSL", ToolCategory.BUILD),
  MAVEN("Maven", ToolCategory.BUILD),
  NPM("NPM", ToolCategory.BUILD),
  YARN("Yarn", ToolCategory.BUILD),
  SBT("sbt", ToolCategory.BUILD),

  // CI
  GITLAB_CI("GitLab CI", ToolCategory.CI),
  GITHUB_ACTIONS("GitHub Actions", ToolCategory.CI),
  CODEOWNERS("CODEOWNERS", ToolCategory.CI),

  // Container
  DOCKER("Docker", ToolCategory.CONTAINER),
  DOCKER_COMPOSE("Docker Compose", ToolCategory.CONTAINER),

  // Runtime
  NODE("Node.js", ToolCategory.RUNTIME),

  // VCS
  GIT("Git", ToolCategory.VCS),

  // Format
  EDITORCONFIG("EditorConfig", ToolCategory.FORMAT),
  ESLINT("ESLint", ToolCategory.FORMAT),
  PRETTIER("Prettier", ToolCategory.FORMAT),

  // Security
  RENOVATE("Renovate", ToolCategory.SECURITY),

  // IDE
  INTELLIJ_IDEA("IntelliJ IDEA", ToolCategory.IDE),
  VS_CODE("Visual Studio Code", ToolCategory.IDE),
}

enum class ToolCategory(val title: String) {
  BUILD("Build"),
  CI("CI"),
  CONTAINER("Container"),
  FORMAT("Format"),
  IDE("IDE"),
  RUNTIME("Runtime"),
  SECURITY("Security"),
  VCS("VCS"),
}
