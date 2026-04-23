package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.*
import org.techsheet.cli.util.MarkdownRenderer
import org.techsheet.cli.util.formatDefault

class MarkdownReporter(
  path: Path,
  fs: FileSystem = FileSystem.SYSTEM,
) : AbstractFileReporter(path, fs) {

  override fun serialize(report: TechSheetReport): String = buildString {
    appendLine("# TechSheet")
    appendLine()
    appendLine(formatMeta(report.meta))
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

  private fun formatMeta(meta: ReportMeta): String =
    "`${meta.generatedAt.formatDefault()}` ‧ `v${meta.generatorVersion}`"

  private fun LanguageEntry.asTableRow() =
    listOf(name, version(version), url, "")

  private fun FrameworkEntry.asTableRow() =
    listOf(name, version(version), category, url, "")

  private fun ServiceEntry.asTableRow() =
    listOf(name, version(version), category, url, "")

  private fun ToolEntry.asTableRow() =
    listOf(displayName(), version(version), category, url, "")

  private fun version(v: String?): String = v?.let { "`$it`" } ?: ""
}
