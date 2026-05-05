package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import org.techsheet.cli.CLI_VERSION
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.util.AnsiStyle

class ConsoleReporter(
  private val report: TechSheetReport,
  fs: FileSystem,
  plain: Boolean = false,
) : Reporter(fs) {

  private val style = AnsiStyle(plain)
  private val itemPrefix = if (plain) "- " else ""

  override fun serialize(): String {
    val body = renderBody()
    val width = maxOf(MIN_WIDTH, body.maxOf { AnsiStyle.visibleLength(it) } + 2)

    return buildList {
      add("")
      add(topRule(width))
      add("")
      addAll(body)
      add(style.cyan("─".repeat(width)))
      add("")
    }.joinToString("\n")
  }

  override fun report(targetFile: Path): Nothing =
    throw UnsupportedOperationException("ConsoleReporter does not support file output")

  private fun renderBody(): List<String> = buildList {
    val sections = listOfNotNull(
      flatSection("Languages", report.languages) { Entry(it.id, it.name, it.version) },
      categorizedSection("Frameworks", report.frameworks, { it.category }) { Entry(it.id, it.name, it.version) },
      categorizedSection("Services", report.services, { it.category }) { Entry(it.id, it.name, it.version) },
      categorizedSection("Tools", report.tools, { it.category }) { Entry(it.id, displayName(it.name, it.flavor), it.version) },
    )
    if (sections.isEmpty()) {
      add(" Nothing detected.")
    } else {
      sections.forEach { addAll(it); add("") }
      add(summary())
    }
  }

  private fun <T> flatSection(
    header: String,
    items: List<T>,
    asEntry: (T) -> Entry,
  ): List<String>? = items.takeIf { it.isNotEmpty() }?.let { list ->
    val entries = list.map(asEntry)
    val nameWidth = entries.maxOf { it.name.length }
    val versionWidth = entries.maxOf { (it.version ?: "").length }
    buildList {
      add(sectionHeader(header))
      entries.forEach { add(itemLine(it, nameWidth, versionWidth)) }
    }
  }

  private fun <T> categorizedSection(
    header: String,
    items: List<T>,
    categoryOf: (T) -> String,
    asEntry: (T) -> Entry,
  ): List<String>? = items.takeIf { it.isNotEmpty() }?.let { list ->
    val mapped = list.map { categoryOf(it) to asEntry(it) }
    val nameWidth = mapped.maxOf { it.second.name.length }
    val versionWidth = mapped.maxOf { (it.second.version ?: "").length }
    val grouped = mapped.groupBy({ it.first }, { it.second })
    buildList {
      add(sectionHeader(header))
      grouped.keys.sorted().forEach { category ->
        grouped[category]?.let { entries ->
          add(" ${style.green(category)}")
          entries.forEach { add(itemLine(it, nameWidth, versionWidth)) }
        }
      }
    }
  }

  private fun itemLine(entry: Entry, nameWidth: Int, versionWidth: Int): String {
    val namePart = entry.name.padEnd(nameWidth)
    val versionPart = if (versionWidth > 0) {
      val v = entry.version
      if (v != null) "  ${style.dim(v.padEnd(versionWidth))}"
      else "  " + " ".repeat(versionWidth)
    } else ""
    return "   $itemPrefix$namePart$versionPart  ${style.dim(entry.id)}"
  }

  private fun sectionHeader(text: String): String = " ${style.yellowBold(text)}"

  private fun displayName(name: String, flavor: String?): String =
    flavor?.let { "$name ($it)" } ?: name

  private fun summary(): String {
    val parts = listOf(
      pluralize(report.languages.size, "language", "languages"),
      pluralize(report.frameworks.size, "framework", "frameworks"),
      pluralize(report.services.size, "service", "services"),
      pluralize(report.tools.size, "tool", "tools"),
    )
    return " " + style.dim("Total: " + parts.joinToString(" · "))
  }

  private fun pluralize(n: Int, singular: String, plural: String): String =
    "$n ${if (n == 1) singular else plural}"

  private fun topRule(width: Int): String {
    val title = " TechSheet v$CLI_VERSION "
    val tail = "─".repeat(width - LEAD_DASHES - title.length)
    return style.cyan("─".repeat(LEAD_DASHES) + title + tail)
  }

  private data class Entry(val id: String, val name: String, val version: String?)

  companion object {
    private const val MIN_WIDTH = 60
    private const val LEAD_DASHES = 5
  }
}
