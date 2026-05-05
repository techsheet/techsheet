package org.techsheet.cli.reporter

import okio.FileSystem
import org.techsheet.cli.domain.*
import org.techsheet.cli.util.MarkdownRenderer

class MarkdownReporter(
  private val report: TechSheetReport,
  fs: FileSystem,
) : Reporter(fs) {

  override fun serialize(): String = buildString {
    appendLine("# TechSheet")
    appendSection("Languages", LANGUAGE_SECTION_HEADERS, report.languages.map { it.asTableRow() })
    appendSection("Frameworks", FRAMEWORK_SECTION_HEADERS, report.frameworks.map { it.asTableRow() })
    appendSection("Services", SERVICE_SECTION_HEADERS, report.services.map { it.asTableRow() })
    appendSection("Tools", TOOL_SECTION_HEADERS, report.tools.map { it.asTableRow() })
  }

  private fun StringBuilder.appendSection(title: String, headers: List<String>, rows: List<List<String>>) {
    appendLine()
    appendLine("## $title")
    appendLine()
    if (rows.isEmpty()) {
      appendLine("*No ${title.lowercase()}*")
    } else {
      val placeholder = List(headers.size) { "" }
      append(MarkdownRenderer.markdownTable(headers, rows + listOf(placeholder)))
    }
  }

  private fun LanguageEntry.asTableRow() =
    listOf("[$name]($url)", version(version), "`$id`", "")

  private fun FrameworkEntry.asTableRow() =
    listOf("[$name]($url)", version(version), category, "`$id`", "")

  private fun ServiceEntry.asTableRow() =
    listOf("[$name]($url)", version(version), category, "`$id`", "")

  private fun ToolEntry.asTableRow() =
    listOf("[${displayName()}]($url)", version(version), category, "`$id`", "")

  private fun version(v: String?): String = v?.let { "`$it`" } ?: ""
}
