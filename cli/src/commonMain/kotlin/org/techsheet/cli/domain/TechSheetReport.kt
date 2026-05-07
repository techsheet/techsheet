package org.techsheet.cli.domain

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.Serializable

@Serializable
data class TechSheetReport(
  @EncodeDefault(EncodeDefault.Mode.ALWAYS)
  val schema: Int = 2,
  val project: Project?,
  val languages: List<LanguageEntry>,
  val frameworks: List<FrameworkEntry>,
  val services: List<ServiceEntry>,
  val tools: List<ToolEntry>,
) {
  companion object {
    fun of(sheet: TechSheet): TechSheetReport = TechSheetReport(
      project = sheet.project,
      languages = sheet.languages.map {
        LanguageEntry(
          id = it.type.id,
          name = it.type.title,
          url = it.type.url,
          version = it.version,
        )
      },
      frameworks = sheet.frameworks.map {
        FrameworkEntry(
          id = it.type.id,
          name = it.type.title,
          category = it.type.category.title,
          url = it.type.url,
          version = it.version,
        )
      },
      services = sheet.services.map {
        ServiceEntry(
          id = it.type.id,
          name = it.type.title,
          category = it.type.category.title,
          url = it.type.url,
          version = it.version,
        )
      },
      tools = sheet.tools.map {
        ToolEntry(
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
}

@Serializable
data class LanguageEntry(
  val id: String,
  val name: String,
  val url: String,
  val version: String? = null,
)

@Serializable
data class FrameworkEntry(
  val id: String,
  val name: String,
  val category: String,
  val url: String,
  val version: String? = null,
)

@Serializable
data class ServiceEntry(
  val id: String,
  val name: String,
  val category: String,
  val url: String,
  val version: String? = null,
)

@Serializable
data class ToolEntry(
  val id: String,
  val name: String,
  val category: String,
  val url: String,
  val version: String? = null,
  val flavor: String? = null,
)
