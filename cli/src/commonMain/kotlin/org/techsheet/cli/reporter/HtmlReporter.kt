package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.FrameworkEntry
import org.techsheet.cli.domain.LanguageEntry
import org.techsheet.cli.domain.ReportMeta
import org.techsheet.cli.domain.ServiceEntry
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.domain.ToolEntry

class HtmlReporter(
  path: Path,
  fs: FileSystem = FileSystem.SYSTEM,
) : AbstractFileReporter(path, fs) {

  override fun serialize(report: TechSheetReport): String = buildString {
    appendLine("<!DOCTYPE html>")
    appendLine("""<html lang="en">""")
    appendLine("<head>")
    appendLine("""  <meta charset="utf-8">""")
    appendLine("""  <meta name="viewport" content="width=device-width, initial-scale=1">""")
    appendLine("  <title>TechSheet</title>")
    appendLine("""  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"""")
    appendLine("""        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">""")
    appendLine("</head>")
    appendLine("<body>")
    appendLine("""<main class="container-fluid py-5 px-5">""")
    appendLine()
    appendLine("""  <h1 class="display-2">TechSheet</h1>""")
    appendLine("  ${formatMeta(report.meta)}")
    appendLine()
    appendSection("languages", "Languages", LANGUAGE_HEADERS, report.languages.map(::languageRow))
    appendLine()
    appendSection("frameworks", "Frameworks", FRAMEWORK_HEADERS, report.frameworks.map(::frameworkRow))
    appendLine()
    appendSection("services", "Services", SERVICE_HEADERS, report.services.map(::serviceRow))
    appendLine()
    appendSection("tools", "Tools", TOOL_HEADERS, report.tools.map(::toolRow))
    appendLine("</main>")
    appendLine()
    appendLine("""<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"""")
    appendLine("""        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"""")
    appendLine("""        crossorigin="anonymous"></script>""")
    appendLine("</body>")
    appendLine("</html>")
  }

  private fun StringBuilder.appendSection(id: String, title: String, headers: List<String>, rows: List<List<String>>) {
    appendLine("""  <section id="$id" class="pb-5">""")
    appendLine("""    <h2 class="pb-2">$title</h2>""")
    if (rows.isEmpty()) {
      appendLine("    <p><em>No ${title.lowercase()}</em></p>")
    } else {
      appendLine("""    <table class="table table-hover">""")
      appendLine("      <thead>")
      appendLine("      <tr>")
      headers.forEach { appendLine("        <th>$it</th>") }
      appendLine("      </tr>")
      appendLine("      </thead>")
      appendLine("      <tbody>")
      rows.forEach { appendRow(it) }
      appendLine("      </tbody>")
      appendLine("    </table>")
    }
    appendLine("  </section>")
  }

  private fun StringBuilder.appendRow(cells: List<String>) {
    appendLine("      <tr>")
    cells.forEach { appendLine("        $it") }
    appendLine("      </tr>")
  }

  private fun formatMeta(meta: ReportMeta): String =
    "<p><code>${escape(meta.generatedAt.formatHuman())}</code> ‧ <code>v${escape(meta.generatorVersion)}</code></p>"

  private fun languageRow(e: LanguageEntry): List<String> = listOf(
    "<td>${escape(e.name)}</td>",
    "<td>${version(e.version)}</td>",
    "<td>${link(e.url)}</td>",
    "<td></td>",
  )

  private fun frameworkRow(e: FrameworkEntry): List<String> = listOf(
    "<td>${escape(e.name)}</td>",
    "<td>${version(e.version)}</td>",
    "<td>${escape(e.category)}</td>",
    "<td>${link(e.url)}</td>",
    "<td></td>",
  )

  private fun serviceRow(e: ServiceEntry): List<String> = listOf(
    "<td>${escape(e.name)}</td>",
    "<td>${version(e.version)}</td>",
    "<td>${escape(e.category)}</td>",
    "<td>${link(e.url)}</td>",
    "<td></td>",
  )

  private fun toolRow(e: ToolEntry): List<String> {
    val name = e.flavor?.let { "${escape(e.name)} (${escape(it)})" } ?: escape(e.name)
    return listOf(
      "<td>$name</td>",
      "<td>${version(e.version)}</td>",
      "<td>${escape(e.category)}</td>",
      "<td>${link(e.url)}</td>",
      "<td></td>",
    )
  }

  private fun version(v: String?): String = v?.let { "<code>${escape(it)}</code>" } ?: ""

  private fun link(url: String): String = escape(url).let { """<a href="$it">$it</a>""" }

  private fun escape(s: String): String =
    s.replace("&", "&amp;")
      .replace("<", "&lt;")
      .replace(">", "&gt;")
      .replace("\"", "&quot;")

  companion object {
    private val LANGUAGE_HEADERS = listOf("Name", "Version", "URL", "Notes")
    private val FRAMEWORK_HEADERS = listOf("Name", "Version", "Category", "URL", "Notes")
    private val SERVICE_HEADERS = listOf("Name", "Version", "Category", "URL", "Notes")
    private val TOOL_HEADERS = listOf("Name", "Version", "Category", "URL", "Notes")
  }
}
