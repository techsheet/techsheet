package org.techsheet.cli.reporter

import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyCategory
import org.techsheet.cli.domain.ToolCategory

class ConsoleReporter(
  private val plain: Boolean = false,
  private val emit: (String) -> Unit = ::println,
) : Reporter {

  private val style = Style(plain)
  private val itemPrefix = if (plain) "- " else ""

  override fun report(sheet: TechSheet) {
    val body = renderBody(sheet)
    val width = maxOf(MIN_WIDTH, body.maxOf { Style.visibleLength(it) } + 2)
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
      flatSection("Languages", sheet.languages) { it.type.title to it.version },
      categorizedSection("Frameworks & Libraries", sheet.technologies, TechnologyCategory.entries, { it.type.category }, { it.title }) {
        it.type.title to it.version
      },
      categorizedSection("Tools", sheet.tools, ToolCategory.entries, { it.type.category }, { it.title }) {
        it.type.title to it.version
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
    asEntry: (T) -> Pair<String, String?>,
  ): List<String>? = items.takeIf { it.isNotEmpty() }?.let {
    buildList {
      add(sectionHeader(header))
      it.forEach { add(itemLine(asEntry(it))) }
    }
  }

  private fun <T, C : Enum<C>> categorizedSection(
    header: String,
    items: List<T>,
    order: List<C>,
    categoryOf: (T) -> C,
    categoryTitle: (C) -> String,
    asEntry: (T) -> Pair<String, String?>,
  ): List<String>? = items.takeIf { it.isNotEmpty() }?.let {
    buildList {
      add(sectionHeader(header))
      val grouped = it.groupBy(categoryOf)
      order.forEach { category ->
        grouped[category]?.let { group ->
          add(" ${style.green(categoryTitle(category))}")
          group.forEach { add(itemLine(asEntry(it))) }
        }
      }
    }
  }

  private fun sectionHeader(text: String): String = " ${style.yellowBold(text)}"

  private fun itemLine(entry: Pair<String, String?>): String {
    val (title, version) = entry
    val versionPart = version?.let { " ${style.dim(it)}" }.orEmpty()
    return "   $itemPrefix$title$versionPart"
  }

  private fun summary(sheet: TechSheet): String {
    val parts = listOf(
      pluralize(sheet.languages.size, "language", "languages"),
      pluralize(sheet.technologies.size, "framework", "frameworks"),
      pluralize(sheet.tools.size, "tool", "tools"),
    )
    return " " + style.dim("Total: " + parts.joinToString(" · "))
  }

  private fun pluralize(n: Int, singular: String, plural: String): String =
    "$n ${if (n == 1) singular else plural}"

  private fun topRule(width: Int): String {
    val title = " TechSheet "
    val tail = "─".repeat(width - LEAD_DASHES - title.length)
    return style.cyan("─".repeat(LEAD_DASHES) + title + tail)
  }

  companion object {
    private const val MIN_WIDTH = 60
    private const val LEAD_DASHES = 5
  }
}
