package org.techsheet.cli.domain

import org.techsheet.schema.Framework
import org.techsheet.schema.Language
import org.techsheet.schema.Project
import org.techsheet.schema.Service
import org.techsheet.schema.TechSheet
import org.techsheet.schema.Tool

data class DetectionResult(
  val project: Project? = null,
  val languages: List<DetectedLanguage> = emptyList(),
  val frameworks: List<DetectedFramework> = emptyList(),
  val services: List<DetectedService> = emptyList(),
  val tools: List<DetectedTool> = emptyList(),
) {

  fun withLanguage(language: DetectedLanguage): DetectionResult =
    copy(languages = languages
      .mergeInto(language, DetectedLanguage::type) { existing, new ->
        existing.copy(version = pickVersion(existing.version, new.version))
      }
      .sortedBy { it.type.title.lowercase() })

  fun withLanguage(type: LanguageType, version: String? = null): DetectionResult =
    withLanguage(DetectedLanguage(type = type, version = version))

  fun withFramework(framework: DetectedFramework): DetectionResult =
    copy(frameworks = frameworks
      .mergeInto(framework, DetectedFramework::type) { existing, new ->
        existing.copy(version = pickVersion(existing.version, new.version))
      }
      .sortedWith(compareBy({ it.type.category.title.lowercase() }, { it.type.title.lowercase() })))

  fun withFramework(type: FrameworkType, version: String? = null): DetectionResult =
    withFramework(DetectedFramework(type = type, version = version))

  fun withService(service: DetectedService): DetectionResult =
    copy(services = services
      .mergeInto(service, DetectedService::type) { existing, new ->
        existing.copy(version = pickVersion(existing.version, new.version))
      }
      .sortedWith(compareBy({ it.type.category.title.lowercase() }, { it.type.title.lowercase() })))

  fun withService(type: ServiceType, version: String? = null): DetectionResult =
    withService(DetectedService(type = type, version = version))

  fun withTool(tool: DetectedTool): DetectionResult =
    copy(tools = tools
      .mergeInto(tool, DetectedTool::type) { existing, new ->
        existing.copy(
          version = pickVersion(existing.version, new.version),
          flavor = existing.flavor ?: new.flavor,
        )
      }
      .sortedWith(compareBy({ it.type.category.title.lowercase() }, { it.type.title.lowercase() })))

  fun withTool(type: ToolType, version: String? = null, flavor: String? = null): DetectionResult =
    withTool(DetectedTool(type = type, version = version, flavor = flavor))

  fun hasLanguage(type: LanguageType): Boolean = languages.any { it.type == type }
  fun hasFramework(type: FrameworkType): Boolean = frameworks.any { it.type == type }
  fun hasService(type: ServiceType): Boolean = services.any { it.type == type }
  fun hasTool(type: ToolType): Boolean = tools.any { it.type == type }

  fun isEmpty(): Boolean = languages.isEmpty() && frameworks.isEmpty() && services.isEmpty() && tools.isEmpty()

  operator fun plus(other: DetectionResult): DetectionResult =
    other.languages.fold(this, DetectionResult::withLanguage)
      .let { acc -> other.frameworks.fold(acc, DetectionResult::withFramework) }
      .let { acc -> other.services.fold(acc, DetectionResult::withService) }
      .let { acc -> other.tools.fold(acc, DetectionResult::withTool) }

  fun toTechSheet(): TechSheet = TechSheet(
    project = project,
    languages = languages.map {
      Language(
        id = it.type.id,
        name = it.type.title,
        url = it.type.url,
        version = it.version,
      )
    },
    frameworks = frameworks.map {
      Framework(
        id = it.type.id,
        name = it.type.title,
        category = it.type.category.title,
        url = it.type.url,
        version = it.version,
      )
    },
    services = services.map {
      Service(
        id = it.type.id,
        name = it.type.title,
        category = it.type.category.title,
        url = it.type.url,
        version = it.version,
      )
    },
    tools = tools.map {
      Tool(
        id = it.type.id,
        name = it.type.title,
        category = it.type.category.title,
        url = it.type.url,
        version = it.version,
        flavor = it.flavor,
      )
    },
  )
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
