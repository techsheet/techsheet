package org.techsheet.cli.domain

data class TechSheet(
  val languages: List<Language> = emptyList(),
  val frameworks: List<Framework> = emptyList(),
  val services: List<Service> = emptyList(),
  val tools: List<Tool> = emptyList(),
) {

  fun withLanguage(language: Language): TechSheet =
    copy(languages = languages + language)

  fun withLanguage(type: LanguageType, version: String? = null): TechSheet =
    withLanguage(Language(type = type, version = version))

  fun withFramework(framework: Framework): TechSheet =
    copy(frameworks = frameworks + framework)

  fun withFramework(type: FrameworkType, version: String? = null): TechSheet =
    withFramework(Framework(type = type, version = version))

  fun withService(service: Service): TechSheet =
    copy(services = services + service)

  fun withService(type: ServiceType, version: String? = null): TechSheet =
    withService(Service(type = type, version = version))

  fun withTool(tool: Tool): TechSheet =
    copy(tools = tools + tool)

  fun withTool(type: ToolType, version: String? = null): TechSheet =
    withTool(Tool(type = type, version = version))

  operator fun plus(other: TechSheet): TechSheet = copy(
    languages = languages + other.languages,
    frameworks = frameworks + other.frameworks,
    services = services + other.services,
    tools = tools + other.tools,
  )

  companion object {
    fun empty() = TechSheet()
  }
}
