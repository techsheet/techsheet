package org.techsheet.cli

import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.optionalValue
import okio.FileNotFoundException
import okio.FileSystem
import okio.IOException
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.techsheet.cli.domain.FrameworkCategory
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.ServiceCategory
import org.techsheet.cli.domain.ServiceType
import org.techsheet.cli.domain.ToolCategory
import org.techsheet.cli.domain.ToolType
import org.techsheet.cli.util.AnsiStyle
import org.techsheet.cli.util.MarkdownRenderer

class DetectorsCommand : CoreCliktCommand(name = "detectors") {

  private val ci: Boolean by option("--ci", help = "Render the output without ANSI colors").flag()

  private val markdown: String? by option(
    "-m", "--markdown",
    help = "Write the detector list as Markdown (optionally specify output path with =)",
  ).optionalValue("detectors.md")

  override fun help(context: Context): String = """
    List all technologies that techsheet can cureently detect.
  """.trimIndent()

  override fun run() {
    markdown?.let { filename ->
      val target = filename.toPath()
      try {
        target.parent?.let { FileSystem.SYSTEM.createDirectories(it) }
        FileSystem.SYSTEM.write(target) { writeUtf8(renderMarkdown()) }
      } catch (e: FileNotFoundException) {
        throw CliktError("Cannot write Markdown detector list to $target: ${e.message ?: "path not found or not writable"}")
      } catch (e: IOException) {
        throw CliktError("I/O error writing Markdown detector list to $target: ${e.message ?: e::class.simpleName}")
      } catch (e: Exception) {
        val detail = listOfNotNull(e::class.simpleName, e.message).joinToString(": ")
        throw CliktError("Unexpected error writing Markdown detector list to $target: $detail")
      }
      println("Wrote Markdown detector list to $target")
      return
    }

    val style = AnsiStyle(ci)

    buildList {
      add("")
      add(style.dim("TechSheet v$CLI_VERSION currently supports:"))
      add("")
      addAll(if (ci) bulletList(style) else table(style))
    }.forEach(::println)
  }

  // ---------- Markdown (--markdown): portable docs ----------

  private fun renderMarkdown(): String = buildString {
    appendLine("# TechSheet Detectors")
    appendLine()
    appendLine("`v$CLI_VERSION`")
    appendMarkdownSection(
      this, "Languages", LANGUAGE_HEADERS,
      LanguageType.entries
        .map { listOf(it.title, it.url) }
        .sortedBy { it[0].lowercase() },
    )
    appendMarkdownSection(
      this, "Frameworks", CATEGORIZED_HEADERS,
      FrameworkType.entries
        .map { listOf(it.title, it.category.title, it.url) }
        .sortedWith(compareBy({ it[1].lowercase() }, { it[0].lowercase() })),
    )
    appendMarkdownSection(
      this, "Services", CATEGORIZED_HEADERS,
      ServiceType.entries
        .map { listOf(it.title, it.category.title, it.url) }
        .sortedWith(compareBy({ it[1].lowercase() }, { it[0].lowercase() })),
    )
    appendMarkdownSection(
      this, "Tools", CATEGORIZED_HEADERS,
      ToolType.entries
        .map { listOf(it.title, it.category.title, it.url) }
        .sortedWith(compareBy({ it[1].lowercase() }, { it[0].lowercase() })),
    )
  }

  private fun appendMarkdownSection(
    sb: StringBuilder,
    title: String,
    headers: List<String>,
    rows: List<List<String>>,
  ) {
    sb.appendLine()
    sb.appendLine("## $title")
    sb.appendLine()
    sb.appendLine("*Currently supporting **${rows.size}** ${title.lowercase()}:*")
    sb.appendLine()
    sb.append(MarkdownRenderer.markdownTable(headers, rows))
  }

  // ---------- Plain (--ci): bulleted list with category subheaders ----------

  private fun bulletList(style: AnsiStyle): List<String> = buildList {
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

  private fun flatSection(style: AnsiStyle, header: String, items: List<String>): List<String> =
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
    style: AnsiStyle,
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

  private fun table(style: AnsiStyle): List<String> {
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
    style: AnsiStyle,
    header: String,
    rows: List<Row>,
    nameWidth: Int,
    categoryWidth: Int,
  ): List<String> = rows.takeIf { it.isNotEmpty() }
    ?.sortedWith(compareBy({ it.category?.lowercase().orEmpty() }, { it.name.lowercase() }))
    ?.let { sorted ->
      buildList {
        add(sectionTitle(style, header, sorted.size))
        sorted.forEach { add(tableRow(style, it, nameWidth, categoryWidth)) }
        add("")
      }
    }
    .orEmpty()

  private fun tableRow(style: AnsiStyle, row: Row, nameWidth: Int, categoryWidth: Int): String {
    val nameCol = row.name.padEnd(nameWidth)
    val categoryCol = row.category?.let(style::green).orEmpty().padVisibleEnd(categoryWidth)
    val urlCol = style.dim(row.url)
    return "   $nameCol  $categoryCol  $urlCol"
  }

  private fun String.padVisibleEnd(target: Int): String =
    this + " ".repeat(maxOf(0, target - AnsiStyle.visibleLength(this)))

  // ---------- Shared ----------

  private fun sectionTitle(style: AnsiStyle, title: String, count: Int): String =
    " ${style.yellowBold(title)} ${style.dim("($count)")}"

  private data class Row(val name: String, val category: String?, val url: String)

  companion object {
    private val LANGUAGE_HEADERS = listOf("Name", "URL")
    private val CATEGORIZED_HEADERS = listOf("Name", "Category", "URL")
  }
}
