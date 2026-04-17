package org.techsheet.cli.domain

data class Tool(
  val type: ToolType,
  val version: String?,
)

enum class ToolType(
  val title: String,
  val url: String,
  val category: ToolCategory
) {

  // Build
  GRADLE("Gradle", "https://techsheet.org/tool/gradle", ToolCategory.BUILD),
  GRADLE_KOTLIN("Gradle - Kotlin DSL", "https://techsheet.org/tool/gradle-kotlin", ToolCategory.BUILD),
  GRADLE_GROOVY("Gradle - Groovy DSL", "https://techsheet.org/tool/gradle-groovy", ToolCategory.BUILD),
  MAVEN("Maven", "https://techsheet.org/tool/maven", ToolCategory.BUILD),
  NPM("NPM", "https://techsheet.org/tool/npm", ToolCategory.BUILD),
  YARN("Yarn", "https://techsheet.org/tool/yarn", ToolCategory.BUILD),
  SBT("sbt", "https://techsheet.org/tool/sbt", ToolCategory.BUILD),

  // CI
  GITLAB_CI("GitLab CI", "https://techsheet.org/tool/gitlab-ci", ToolCategory.CI),
  GITHUB_ACTIONS("GitHub Actions", "https://techsheet.org/tool/github-actions", ToolCategory.CI),
  CODEOWNERS("CODEOWNERS", "https://techsheet.org/tool/codeowners", ToolCategory.CI),

  // Container
  DOCKER("Docker", "https://techsheet.org/tool/docker", ToolCategory.CONTAINER),
  DOCKER_COMPOSE("Docker Compose", "https://techsheet.org/tool/docker-compose", ToolCategory.CONTAINER),

  // Runtime
  NODE("Node.js", "https://techsheet.org/tool/nodejs", ToolCategory.RUNTIME),

  // VCS
  GIT("Git", "https://techsheet.org/tool/git", ToolCategory.VCS),

  // Format
  EDITORCONFIG("EditorConfig", "https://techsheet.org/tool/editorconfig", ToolCategory.FORMAT),
  ESLINT("ESLint", "https://techsheet.org/tool/eslint", ToolCategory.FORMAT),
  PRETTIER("Prettier", "https://techsheet.org/tool/prettier", ToolCategory.FORMAT),

  // Security
  RENOVATE("Renovate", "https://techsheet.org/tool/renovate", ToolCategory.SECURITY),

  // IDE
  INTELLIJ_IDEA("IntelliJ IDEA", "https://techsheet.org/tool/intellij-idea", ToolCategory.IDE),
  VS_CODE("Visual Studio Code", "https://techsheet.org/tool/vscode", ToolCategory.IDE),
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
