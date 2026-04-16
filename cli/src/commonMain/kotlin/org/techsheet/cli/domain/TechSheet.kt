package org.techsheet.cli.domain

data class TechSheet(
  val languages: List<Language> = emptyList(),
  val technologies: List<Technology> = emptyList(),
  val tools: List<Tool> = emptyList(),
) {

  fun withLanguage(language: Language): TechSheet =
    copy(languages = languages + language)

  fun withLanguage(type: LanguageType, version: String? = null): TechSheet =
    withLanguage(Language(type = type, version = version))

  fun withTechnology(technology: Technology): TechSheet =
    copy(technologies = technologies + technology)

  fun withTechnology(type: TechnologyType, version: String? = null): TechSheet =
    withTechnology(Technology(type = type, version = version))

  fun withTool(tool: Tool): TechSheet =
    copy(tools = tools + tool)

  fun withTool(type: ToolType, version: String? = null): TechSheet =
    withTool(Tool(type = type, version = version))

  operator fun plus(other: TechSheet): TechSheet = copy(
    languages = languages + other.languages,
    technologies = technologies + other.technologies,
    tools = tools + other.tools,
  )

  companion object {
    fun empty() = TechSheet()
  }
}
