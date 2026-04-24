package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.*
import org.techsheet.cli.util.formatDefault

class HtmlReporter(
  path: Path,
  fs: FileSystem = FileSystem.SYSTEM,
) : AbstractFileReporter(path, fs) {

  override fun serialize(report: TechSheetReport): String = buildString {
    appendLine("<!DOCTYPE html>")
    appendLine("""<html lang="en">""")
    appendLine("<head>")
    appendLine("""  <meta charset="utf-8">""")
    appendLine("""  <meta name="generator" content="TechSheet.org CLI ${report.meta.generatorVersion}">""")
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
    appendSection("languages", "Languages", LANGUAGE_SECTION_HEADERS, report.languages.map { it.asTableRow() })
    appendLine()
    appendSection("frameworks", "Frameworks", FRAMEWORK_SECTION_HEADERS, report.frameworks.map { it.asTableRow() })
    appendLine()
    appendSection("services", "Services", SERVICE_SECTION_HEADERS, report.services.map { it.asTableRow() })
    appendLine()
    appendSection("tools", "Tools", TOOL_SECTION_HEADERS, report.tools.map { it.asTableRow() })
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
      rows.forEach { cells ->
        appendLine("      <tr>")
        cells.forEach { appendLine("        <td>$it</td>") }
        appendLine("      </tr>")
      }
      appendLine("      </tbody>")
      appendLine("    </table>")
    }
    appendLine("  </section>")
  }

  private fun formatMeta(meta: ReportMeta): String =
    "<p><code>${escape(meta.generatedAt.formatDefault())}</code> ‧ <code>v${escape(meta.generatorVersion)}</code></p>"

  private fun LanguageEntry.asTableRow() =
    listOf(escape(name), version(version), link(url), "")

  private fun FrameworkEntry.asTableRow() =
    listOf(escape(name), version(version), escape(category), link(url), "")

  private fun ServiceEntry.asTableRow() =
    listOf(escape(name), version(version), escape(category), link(url), "")

  private fun ToolEntry.asTableRow() =
    listOf(escape(displayName()), version(version), escape(category), link(url), "")

  private fun version(v: String?): String = v?.let { "<code>${escape(it)}</code>" } ?: ""

  private fun link(url: String): String = escape(url).let { """<a href="$it">$it</a>""" }

  private fun escape(s: String): String =
    s.replace("&", "&amp;")
      .replace("<", "&lt;")
      .replace(">", "&gt;")
      .replace("\"", "&quot;")
}
