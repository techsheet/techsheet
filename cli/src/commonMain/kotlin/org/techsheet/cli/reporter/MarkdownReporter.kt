package org.techsheet.cli.reporter

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.FrameworkEntry
import org.techsheet.cli.domain.LanguageEntry
import org.techsheet.cli.domain.ReportMeta
import org.techsheet.cli.domain.ServiceEntry
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.domain.ToolEntry

class MarkdownReporter(
  path: Path,
  fs: FileSystem = FileSystem.SYSTEM,
) : AbstractFileReporter(path, fs) {

  override fun serialize(report: TechSheetReport): String = buildString {
    appendLine("# TechSheet")
    appendLine()
    appendLine(formatMeta(report.meta))
    appendSection(this, "Languages", LANGUAGE_HEADERS, report.languages.map(::languageRow))
    appendSection(this, "Frameworks", FRAMEWORK_HEADERS, report.frameworks.map(::frameworkRow))
    appendSection(this, "Services", SERVICE_HEADERS, report.services.map(::serviceRow))
    appendSection(this, "Tools", TOOL_HEADERS, report.tools.map(::toolRow))
  }

  private fun appendSection(
    sb: StringBuilder,
    title: String,
    headers: List<String>,
    rows: List<List<String>>,
  ) {
    sb.appendLine()
    sb.appendLine("## $title")
    sb.appendLine()
    if (rows.isEmpty()) {
      sb.appendLine("*No ${title.lowercase()}*")
    } else {
      sb.append(renderTable(headers, rows))
    }
  }

  private fun renderTable(headers: List<String>, rows: List<List<String>>): String {
    val allRows = rows + listOf(List(headers.size) { "" })
    val widths = IntArray(headers.size) { col ->
      maxOf(headers[col].length, allRows.maxOf { it[col].length })
    }
    return buildString {
      appendRow(headers, widths)
      appendSeparator(widths)
      allRows.forEach { appendRow(it, widths) }
    }
  }

  private fun StringBuilder.appendRow(cells: List<String>, widths: IntArray) {
    append('|')
    cells.forEachIndexed { i, cell ->
      append(' ')
      append(cell.padEnd(widths[i]))
      append(' ')
      append('|')
    }
    append('\n')
  }

  private fun StringBuilder.appendSeparator(widths: IntArray) {
    append('|')
    widths.forEach { w ->
      repeat(w + 2) { append('-') }
      append('|')
    }
    append('\n')
  }

  private fun formatMeta(meta: ReportMeta): String {
    val dt = meta.generatedAt.toLocalDateTime(TimeZone.currentSystemDefault())
    val month = MONTH_NAMES[dt.month.ordinal]
    val hh = dt.hour.toString().padStart(2, '0')
    val mm = dt.minute.toString().padStart(2, '0')
    return "`v${meta.generatorVersion}` ‧ `${dt.dayOfMonth}. $month ${dt.year} $hh:$mm`"
  }

  private fun languageRow(e: LanguageEntry): List<String> =
    listOf(e.name, version(e.version), e.url, "")

  private fun frameworkRow(e: FrameworkEntry): List<String> =
    listOf(e.name, version(e.version), e.category, e.url, "")

  private fun serviceRow(e: ServiceEntry): List<String> =
    listOf(e.name, version(e.version), e.category, e.url, "")

  private fun toolRow(e: ToolEntry): List<String> {
    val name = e.flavor?.let { "${e.name} ($it)" } ?: e.name
    return listOf(name, version(e.version), e.category, e.url, "")
  }

  private fun version(v: String?): String = v?.let { "`$it`" } ?: ""

  companion object {
    private val LANGUAGE_HEADERS = listOf("Name", "Version", "URL", "Notes")
    private val FRAMEWORK_HEADERS = listOf("Name", "Version", "Category", "URL", "Notes")
    private val SERVICE_HEADERS = listOf("Name", "Version", "Category", "URL", "Notes")
    private val TOOL_HEADERS = listOf("Name", "Version", "Category", "URL", "Notes")

    private val MONTH_NAMES = listOf(
      "January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December",
    )
  }
}
