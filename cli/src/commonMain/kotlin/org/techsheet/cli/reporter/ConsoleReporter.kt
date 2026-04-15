package org.techsheet.cli.reporter

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.BuildTool
import org.techsheet.cli.domain.ProgrammingLanguage
import org.techsheet.cli.domain.TechSheet

class ConsoleReporter : Reporter {

  override fun report(ctx: AnalyzerContext, sheet: TechSheet) {
    val lines = buildList {
      add("TechSheet for ${ctx.path}")
      add(SEPARATOR)
      section("Build tools", sheet.buildTools, ::formatBuildTool)
      section("Programming languages", sheet.programmingLanguage, ::formatLanguage)
      if (sheet.buildTools.isEmpty() && sheet.programmingLanguage.isEmpty()) {
        add("Nothing detected.")
      }
    }
    lines.forEach(::println)
  }

  private fun <T> MutableList<String>.section(title: String, items: List<T>, format: (T) -> String) {
    if (items.isEmpty()) return
    add("$title:")
    items.map(format).forEach { add("  - $it") }
  }

  private fun formatBuildTool(tool: BuildTool): String =
    "${tool.type.title}${tool.version?.let { " ($it)" }.orEmpty()}"

  private fun formatLanguage(language: ProgrammingLanguage): String =
    "${language.type.title}${language.version?.let { " ($it)" }.orEmpty()}"

  companion object {
    private const val SEPARATOR = "----------------------------------------"
  }
}
