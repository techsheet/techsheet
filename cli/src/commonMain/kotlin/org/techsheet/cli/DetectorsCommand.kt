package org.techsheet.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.CliktError
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.terminal
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.optionalValue
import okio.FileNotFoundException
import okio.FileSystem
import okio.IOException
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.ServiceType
import org.techsheet.cli.domain.ToolType
import org.techsheet.cli.util.ConsolePrinter
import org.techsheet.cli.util.MarkdownRenderer

class DetectorsCommand : CliktCommand(name = "detectors") {

  private val markdown: String? by option(
    "-m", "--markdown",
    help = "Write the detector list as Markdown (optionally specify output path with =)",
  ).optionalValue("detectors.md")

  override fun help(context: Context): String = """
    List all technologies that techsheet can currently detect. Colors and formatting are stripped automatically when
    stdout is not a TTY. Set NO_COLOR=1 to force plain text in any environment.
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
      echo("Wrote Markdown detector list to $target")
      return
    }

    ConsolePrinter(terminal).printDetectors()
  }

  //FIXME: Extract markdown rendering
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

  companion object {
    private val LANGUAGE_HEADERS = listOf("Name", "URL")
    private val CATEGORIZED_HEADERS = listOf("Name", "Category", "URL")
  }
}
