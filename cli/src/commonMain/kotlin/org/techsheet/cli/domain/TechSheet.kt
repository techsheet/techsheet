package org.techsheet.cli.domain

data class TechSheet(
  val project: Project = Project(name = Project.DEFAULT_NAME),
  val languages: List<Language> = emptyList(),
  val frameworks: List<Framework> = emptyList(),
  val services: List<Service> = emptyList(),
  val tools: List<Tool> = emptyList(),
) {

  fun withLanguage(language: Language): TechSheet =
    copy(languages = languages
      .mergeInto(language, Language::type) { existing, new ->
        existing.copy(version = pickVersion(existing.version, new.version))
      }
      .sortedBy { it.type.title.lowercase() })

  fun withLanguage(type: LanguageType, version: String? = null): TechSheet =
    withLanguage(Language(type = type, version = version))

  fun withFramework(framework: Framework): TechSheet =
    copy(frameworks = frameworks
      .mergeInto(framework, Framework::type) { existing, new ->
        existing.copy(version = pickVersion(existing.version, new.version))
      }
      .sortedWith(compareBy({ it.type.category.title.lowercase() }, { it.type.title.lowercase() })))

  fun withFramework(type: FrameworkType, version: String? = null): TechSheet =
    withFramework(Framework(type = type, version = version))

  fun withService(service: Service): TechSheet =
    copy(services = services
      .mergeInto(service, Service::type) { existing, new ->
        existing.copy(version = pickVersion(existing.version, new.version))
      }
      .sortedWith(compareBy({ it.type.category.title.lowercase() }, { it.type.title.lowercase() })))

  fun withService(type: ServiceType, version: String? = null): TechSheet =
    withService(Service(type = type, version = version))

  fun withTool(tool: Tool): TechSheet =
    copy(tools = tools
      .mergeInto(tool, Tool::type) { existing, new ->
        existing.copy(
          version = pickVersion(existing.version, new.version),
          flavor = existing.flavor ?: new.flavor,
        )
      }
      .sortedWith(compareBy({ it.type.category.title.lowercase() }, { it.type.title.lowercase() })))

  fun withTool(type: ToolType, version: String? = null, flavor: String? = null): TechSheet =
    withTool(Tool(type = type, version = version, flavor = flavor))

  fun hasLanguage(type: LanguageType): Boolean = languages.any { it.type == type }
  fun hasFramework(type: FrameworkType): Boolean = frameworks.any { it.type == type }
  fun hasService(type: ServiceType): Boolean = services.any { it.type == type }
  fun hasTool(type: ToolType): Boolean = tools.any { it.type == type }

  fun isEmpty(): Boolean = languages.isEmpty() && frameworks.isEmpty() && services.isEmpty() && tools.isEmpty()

  operator fun plus(other: TechSheet): TechSheet =
    other.languages.fold(this, TechSheet::withLanguage)
      .let { s -> other.frameworks.fold(s, TechSheet::withFramework) }
      .let { s -> other.services.fold(s, TechSheet::withService) }
      .let { s -> other.tools.fold(s, TechSheet::withTool) }

  companion object {
    fun empty() = TechSheet()
  }
}

private inline fun <T> List<T>.mergeInto(
  incoming: T,
  typeOf: (T) -> Any,
  merge: (existing: T, incoming: T) -> T,
): List<T> = indexOfFirst { typeOf(it) == typeOf(incoming) }
  .takeIf { it >= 0 }
  ?.let { idx ->
    mapIndexed { i, existing ->
      if (i == idx) merge(existing, incoming)
      else existing
    }
  }
  ?: (this + incoming)
