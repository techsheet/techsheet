package org.techsheet.cli.domain

import kotlin.time.Clock
import kotlin.time.Instant
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import org.techsheet.cli.CLI_VERSION

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class TechSheetReport(
  @EncodeDefault(EncodeDefault.Mode.ALWAYS) val schema: Int = 1,
  val meta: ReportMeta,
  val languages: List<LanguageEntry>,
  val frameworks: List<FrameworkEntry>,
  val services: List<ServiceEntry>,
  val tools: List<ToolEntry>,
) {
  companion object {
    fun of(sheet: TechSheet): TechSheetReport = TechSheetReport(
      meta = ReportMeta(
        generatedAt = Clock.System.now(),
        generatorVersion = CLI_VERSION,
      ),
      languages = sheet.languages.map {
        LanguageEntry(
          name = it.type.title,
          url = it.type.url,
          version = it.version,
        )
      },
      frameworks = sheet.frameworks.map {
        FrameworkEntry(
          name = it.type.title,
          url = it.type.url,
          category = it.type.category.title,
          version = it.version,
        )
      },
      services = sheet.services.map {
        ServiceEntry(
          name = it.type.title,
          url = it.type.url,
          category = it.type.category.title,
          version = it.version,
        )
      },
      tools = sheet.tools.map {
        ToolEntry(
          name = it.type.title,
          url = it.type.url,
          category = it.type.category.title,
          version = it.version,
          flavor = it.flavor,
        )
      },
    )
  }
}

@Serializable
data class ReportMeta(
  val generatedAt: Instant,
  val generatorVersion: String,
)

@Serializable
data class LanguageEntry(
  val name: String,
  val url: String,
  val version: String? = null,
)

@Serializable
data class FrameworkEntry(
  val name: String,
  val url: String,
  val category: String,
  val version: String? = null,
)

@Serializable
data class ServiceEntry(
  val name: String,
  val url: String,
  val category: String,
  val version: String? = null,
)

@Serializable
data class ToolEntry(
  val name: String,
  val url: String,
  val category: String,
  val version: String? = null,
  val flavor: String? = null,
)
