package org.techsheet.cli

import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import org.techsheet.cli.domain.FrameworkCategory
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.ServiceCategory
import org.techsheet.cli.domain.ServiceType
import org.techsheet.cli.domain.ToolCategory
import org.techsheet.cli.domain.ToolType
import org.techsheet.cli.reporter.Style

class DetectorsCommand : CoreCliktCommand(name = "detectors") {

  private val ci: Boolean by option("--ci", help = "Render the output without ANSI colors").flag()

  override fun run() {
    val style = Style(ci)
    buildList {
      add("")
      add(style.dim("TechSheet v$CLI_VERSION currently supports:"))
      add("")
      addAll(if (ci) bulletList(style) else table(style))
    }.forEach(::println)
  }

  // ---------- Plain (--ci): bulleted list with category subheaders ----------

  private fun bulletList(style: Style): List<String> = buildList {
    addAll(flatSection(style, "Languages", LanguageType.entries.map { it.title }))
    addAll(
      categorizedSection(
        style, "Frameworks",
        FrameworkType.entries, FrameworkCategory.entries,
        { it.category }, { it.title }, { it.title },
      ),
    )
    addAll(
      categorizedSection(
        style, "Services",
        ServiceType.entries, ServiceCategory.entries,
        { it.category }, { it.title }, { it.title },
      ),
    )
    addAll(
      categorizedSection(
        style, "Tools",
        ToolType.entries, ToolCategory.entries,
        { it.category }, { it.title }, { it.title },
      ),
    )
  }

  private fun flatSection(style: Style, header: String, items: List<String>): List<String> =
    items.takeIf { it.isNotEmpty() }
      ?.sortedBy(String::lowercase)
      ?.let { sorted ->
        buildList {
          add(sectionTitle(style, header, sorted.size))
          sorted.forEach { add("   - $it") }
          add("")
        }
      }
      .orEmpty()

  private fun <T, C : Enum<C>> categorizedSection(
    style: Style,
    header: String,
    items: List<T>,
    order: List<C>,
    categoryOf: (T) -> C,
    categoryTitle: (C) -> String,
    itemTitle: (T) -> String,
  ): List<String> = items.takeIf { it.isNotEmpty() }
    ?.let { all ->
      val grouped = all.groupBy(categoryOf)
      buildList {
        add(sectionTitle(style, header, all.size))
        order.forEach { category ->
          grouped[category]?.let { group ->
            add(" ${categoryTitle(category)}")
            group.map(itemTitle).sortedBy(String::lowercase).forEach { add("   - $it") }
          }
        }
        add("")
      }
    }
    .orEmpty()

  // ---------- Colored (default): aligned columns with an inline category cell ----------

  private fun table(style: Style): List<String> {
    val sections = listOf(
      "Languages" to LanguageType.entries.map { Row(it.title, category = null, it.url) },
      "Frameworks" to FrameworkType.entries.map { Row(it.title, it.category.title, it.url) },
      "Services" to ServiceType.entries.map { Row(it.title, it.category.title, it.url) },
      "Tools" to ToolType.entries.map { Row(it.title, it.category.title, it.url) },
    )
    val allRows = sections.flatMap { it.second }
    val nameWidth = allRows.maxOfOrNull { it.name.length } ?: 0
    val categoryWidth = allRows.mapNotNull { it.category }.maxOfOrNull { it.length } ?: 0
    return sections.flatMap { (header, rows) -> flatTable(style, header, rows, nameWidth, categoryWidth) }
  }

  private fun flatTable(
    style: Style,
    header: String,
    rows: List<Row>,
    nameWidth: Int,
    categoryWidth: Int,
  ): List<String> = rows.takeIf { it.isNotEmpty() }
    ?.sortedBy { it.name.lowercase() }
    ?.let { sorted ->
      buildList {
        add(sectionTitle(style, header, sorted.size))
        sorted.forEach { add(tableRow(style, it, nameWidth, categoryWidth)) }
        add("")
      }
    }
    .orEmpty()

  private fun tableRow(style: Style, row: Row, nameWidth: Int, categoryWidth: Int): String {
    val nameCol = row.name.padEnd(nameWidth)
    val categoryCol = row.category?.let(style::green).orEmpty().padVisibleEnd(categoryWidth)
    val urlCol = style.dim(row.url)
    return "   $nameCol  $categoryCol  $urlCol"
  }

  private fun String.padVisibleEnd(target: Int): String =
    this + " ".repeat(maxOf(0, target - Style.visibleLength(this)))

  // ---------- Shared ----------

  private fun sectionTitle(style: Style, title: String, count: Int): String =
    " ${style.yellowBold(title)} ${style.dim("($count)")}"

  private data class Row(val name: String, val category: String?, val url: String)
}
