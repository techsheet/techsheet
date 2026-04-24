package org.techsheet.cli.reporter

import org.techsheet.cli.CLI_VERSION
import org.techsheet.cli.domain.FrameworkCategory
import org.techsheet.cli.domain.ServiceCategory
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolCategory
import org.techsheet.cli.util.AnsiStyle

class ConsoleReporter(
  plain: Boolean = false,
  private val emit: (String) -> Unit = ::println,
) : Reporter {

  private val style = AnsiStyle(plain)
  private val itemPrefix = if (plain) "- " else ""

  override fun report(sheet: TechSheet) {
    val body = renderBody(sheet)
    val width = maxOf(MIN_WIDTH, body.maxOf { AnsiStyle.visibleLength(it) } + 2)
    val lines = buildList {
      add("")
      add(topRule(width))
      add("")
      addAll(body)
      add(style.cyan("─".repeat(width)))
      add("")
    }
    lines.forEach(emit)
  }

  private fun renderBody(sheet: TechSheet): List<String> = buildList {
    val sections = listOfNotNull(
      flatSection(
        "Languages",
        sheet.languages,
      ) { Entry(it.type.id, it.type.title, it.version) },
      categorizedSection(
        "Frameworks",
        sheet.frameworks,
        FrameworkCategory.entries,
        { it.type.category },
        { it.title },
      ) { Entry(it.type.id, it.type.title, it.version) },
      categorizedSection(
        "Services",
        sheet.services,
        ServiceCategory.entries,
        { it.type.category },
        { it.title },
      ) { Entry(it.type.id, it.type.title, it.version) },
      categorizedSection(
        "Tools",
        sheet.tools,
        ToolCategory.entries,
        { it.type.category },
        { it.title },
      ) {
        val label = it.flavor?.let { f -> "${it.type.title} ($f)" } ?: it.type.title
        Entry(it.type.id, label, it.version)
      },
    )
    if (sections.isEmpty()) {
      add(" Nothing detected.")
    } else {
      sections.forEach { addAll(it); add("") }
      add(summary(sheet))
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

  private fun <T, C : Enum<C>> categorizedSection(
    header: String,
    items: List<T>,
    order: List<C>,
    categoryOf: (T) -> C,
    categoryTitle: (C) -> String,
    asEntry: (T) -> Entry,
  ): List<String>? = items.takeIf { it.isNotEmpty() }?.let { list ->
    val mapped = list.map { categoryOf(it) to asEntry(it) }
    val nameWidth = mapped.maxOf { it.second.name.length }
    val versionWidth = mapped.maxOf { (it.second.version ?: "").length }
    val grouped = mapped.groupBy({ it.first }, { it.second })
    buildList {
      add(sectionHeader(header))
      order.forEach { category ->
        grouped[category]?.let { entries ->
          add(" ${style.green(categoryTitle(category))}")
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

  private fun summary(sheet: TechSheet): String {
    val parts = listOf(
      pluralize(sheet.languages.size, "language", "languages"),
      pluralize(sheet.frameworks.size, "framework", "frameworks"),
      pluralize(sheet.services.size, "service", "services"),
      pluralize(sheet.tools.size, "tool", "tools"),
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
