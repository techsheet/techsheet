package org.techsheet.cli.domain

data class TechSheet(
  val tools: List<Tool> = emptyList(),
  val technologies: List<Technology> = emptyList(),
  val programmingLanguage: List<ProgrammingLanguage> = emptyList(),
) {

  fun withTool(tool: Tool): TechSheet =
    copy(tools = tools + tool)

  fun withTool(type: ToolType, version: String? = null): TechSheet =
    withTool(Tool(type = type, version = version))

  fun withTechnology(technology: Technology): TechSheet =
    copy(technologies = technologies + technology)

  fun withTechnology(type: TechnologyType, version: String? = null): TechSheet =
    withTechnology(Technology(type = type, version = version))

  fun withProgrammingLanguage(language: ProgrammingLanguage): TechSheet =
    copy(programmingLanguage = programmingLanguage + language)

  fun withProgrammingLanguage(type: ProgrammingLanguageType, version: String? = null): TechSheet =
    withProgrammingLanguage(ProgrammingLanguage(type = type, version = version))

  operator fun plus(other: TechSheet): TechSheet = copy(
    tools = tools + other.tools,
    technologies = technologies + other.technologies,
    programmingLanguage = programmingLanguage + other.programmingLanguage,
  )

  companion object {
    fun empty() = TechSheet()
  }
}
