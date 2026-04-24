package org.techsheet.cli.util

internal object MarkdownRenderer {

  fun markdownTable(headers: List<String>, rows: List<List<String>>): String {
    val widths = IntArray(headers.size) { col ->
      maxOf(headers[col].length, rows.maxOfOrNull { it[col].length } ?: 0)
    }
    return buildString {
      appendMarkdownRow(headers, widths)
      appendMarkdownSeparator(widths)
      rows.forEach { appendMarkdownRow(it, widths) }
    }
  }

  private fun StringBuilder.appendMarkdownRow(cells: List<String>, widths: IntArray) {
    append('|')
    cells.forEachIndexed { i, cell ->
      append(' ')
      append(cell.padEnd(widths[i]))
      append(' ')
      append('|')
    }
    append('\n')
  }

  private fun StringBuilder.appendMarkdownSeparator(widths: IntArray) {
    append('|')
    widths.forEach { w ->
      repeat(w + 2) { append('-') }
      append('|')
    }
    append('\n')
  }
}
