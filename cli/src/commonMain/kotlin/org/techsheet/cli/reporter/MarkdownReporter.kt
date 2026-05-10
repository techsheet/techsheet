package org.techsheet.cli.reporter

import okio.FileSystem
import org.techsheet.schema.*
import org.techsheet.cli.util.MarkdownRenderer

class MarkdownReporter(
    private val techSheet: TechSheet,
    fs: FileSystem,
) : Reporter(fs) {

  override fun serialize(): String = buildString {
    appendLine("# TechSheet")
    appendSection("Languages", LANGUAGE_SECTION_HEADERS, techSheet.languages.map { it.asTableRow() })
    appendSection("Frameworks", FRAMEWORK_SECTION_HEADERS, techSheet.frameworks.map { it.asTableRow() })
    appendSection("Services", SERVICE_SECTION_HEADERS, techSheet.services.map { it.asTableRow() })
    appendSection("Tools", TOOL_SECTION_HEADERS, techSheet.tools.map { it.asTableRow() })
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

  private fun Language.asTableRow() =
    listOf("[$name](${url ?: ""})", version(version), "`$id`", "")

  private fun Framework.asTableRow() =
    listOf("[$name](${url ?: ""})", version(version), category ?: "", "`$id`", "")

  private fun Service.asTableRow() =
    listOf("[$name](${url ?: ""})", version(version), category ?: "", "`$id`", "")

  private fun Tool.asTableRow() =
    listOf("[${displayName()}](${url ?: ""})", version(version), category ?: "", "`$id`", "")

  private fun version(v: String?): String = v?.let { "`$it`" } ?: ""
}
