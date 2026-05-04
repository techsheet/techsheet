package org.techsheet.cli.domain

data class Tool(
  val type: ToolType,
  val version: String? = null,
  val flavor: String? = null,
)

enum class ToolType(
  override val key: String,
  override val title: String,
  val category: ToolCategory,
) : Technology {

  // Build
  GRADLE("gradle", "Gradle", ToolCategory.BUILD),
  MAVEN("maven", "Maven", ToolCategory.BUILD),
  NPM("npm", "NPM", ToolCategory.BUILD),
  YARN("yarn", "Yarn", ToolCategory.BUILD),
  SBT("sbt", "SBT", ToolCategory.BUILD),
  COMPOSER("composer", "Composer", ToolCategory.BUILD),

  // CI
  GITLAB_CI("gitlab-ci", "GitLab CI", ToolCategory.CI),
  GITHUB_ACTIONS("github-actions", "GitHub Actions", ToolCategory.CI),
  CODEOWNERS("codeowners", "CODEOWNERS", ToolCategory.CI),

  // Container
  DOCKER("docker", "Docker", ToolCategory.CONTAINER),
  DOCKER_COMPOSE("docker-compose", "Docker Compose", ToolCategory.CONTAINER),

  // Runtime
  JVM("jvm", "JVM", ToolCategory.RUNTIME),
  NODE("nodejs", "Node.js", ToolCategory.RUNTIME),

  // VCS
  GIT("git", "Git", ToolCategory.VCS),

  // Format
  EDITORCONFIG("editorconfig", "EditorConfig", ToolCategory.FORMAT),
  ESLINT("eslint", "ESLint", ToolCategory.FORMAT),
  PRETTIER("prettier", "Prettier", ToolCategory.FORMAT),

  // Security
  RENOVATE("renovate", "Renovate", ToolCategory.SECURITY),

  // AI
  CLAUDE("claude", "Claude", ToolCategory.AI),
  GITHUB_COPILOT("github-copilot", "GitHub Copilot", ToolCategory.AI),
  CURSOR("cursor", "Cursor", ToolCategory.AI),
  WINDSURF("windsurf", "Windsurf", ToolCategory.AI),
  AIDER("aider", "Aider", ToolCategory.AI),
  CONTINUE("continue", "Continue", ToolCategory.AI),
  AMAZON_Q("amazon-q", "Amazon Q", ToolCategory.AI),
  CODEIUM("codeium", "Codeium", ToolCategory.AI),
  GEMINI("gemini", "Gemini", ToolCategory.AI),
  CODEX("codex", "OpenAI Codex", ToolCategory.AI),

  // IDE
  INTELLIJ_IDEA("intellij-idea", "IntelliJ IDEA", ToolCategory.IDE),
  VS_CODE("vscode", "Visual Studio Code", ToolCategory.IDE);

  override val type: String = "tool"
}

enum class ToolCategory(val title: String) {
  AI("AI"),
  BUILD("Build"),
  CI("CI"),
  CONTAINER("Container"),
  FORMAT("Format"),
  IDE("IDE"),
  RUNTIME("Runtime"),
  SECURITY("Security"),
  VCS("VCS"),
}
