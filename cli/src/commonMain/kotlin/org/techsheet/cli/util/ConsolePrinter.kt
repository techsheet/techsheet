package org.techsheet.cli.util

import com.github.ajalt.mordant.rendering.AnsiLevel
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*
import com.github.ajalt.mordant.table.ColumnWidth
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal
import org.techsheet.cli.CLI_VERSION
import org.techsheet.cli.domain.*

class ConsolePrinter(val terminal: Terminal) {

  constructor(color: Boolean) :
    this(Terminal(ansiLevel = if (color) null else AnsiLevel.NONE))

  fun printReport(report: TechSheetReport) {
    printHeader()

    printSectionHeader("Languages", report.languages.size)
    report.languages
      .forEach { printLanguage(it) }

    printSectionHeader("Frameworks", report.frameworks.size)
    report.frameworks
      .groupBy { it.category }
      .forEach { (category, frameworks) ->
        printCategoryHeader(category, frameworks.size)
        frameworks.forEach { printFramework(it) }
      }

    printSectionHeader("Services", report.services.size)
    report.services
      .groupBy { it.category }
      .forEach { (category, services) ->
        printCategoryHeader(category, services.size)
        services.forEach { printService(it) }
      }

    printSectionHeader("Tools", report.tools.size)
    report.tools
      .groupBy { it.category }
      .forEach { (category, tools) ->
        printCategoryHeader(category, tools.size)
        tools.forEach { printTool(it) }
      }

    printFooter()
  }

  fun printDetectors() {
    printHeader()

    terminal.println(dim("The following technologies are currently detected:"))

    printDetectorSection("Languages", LanguageType.entries)
    printDetectorSection("Frameworks", FrameworkType.entries)
    printDetectorSection("Services", ServiceType.entries)
    printDetectorSection("Tools", ToolType.entries)

    terminal.println("")
    terminal.println(dim(italic("For more details, visit https://techsheet.org")))

    printFooter()
  }

  fun printHeader() {
    terminal.println("")
    terminal.println(
      buildList {
        add(cyan("─────"))
        add(bold(brightCyan("TechSheet")))
        add(dim(italic("v${CLI_VERSION}")))
        add(cyan("───────────────────────────────────────"))
      }.joinToString(" ")
    )
    terminal.println("")
  }

  private fun printFooter() {
    terminal.println("")
    terminal.println(cyan("──────────────────────────────────────────────────────────────"))
    terminal.println("")
  }

  private fun printSectionHeader(name: String, number: Int) {
    terminal.println("")
    terminal.println(
      buildList {
        add(bold(brightYellow(name)))
        add(italic(yellow("($number)")))
      }.joinToString(" ")
    )
  }

  private fun printCategoryHeader(name: String, number: Int) {
    terminal.println("")
    terminal.println(
      buildList {
        add(bold(brightGreen(" $name")))
        add(italic(green("($number)")))
      }.joinToString(" ")
    )
  }

  private fun printLanguage(lang: LanguageEntry) =
    printEntry(lang.name, lang.version)

  private fun printFramework(framework: FrameworkEntry) =
    printEntry(framework.name, framework.version)

  private fun printService(service: ServiceEntry) =
    printEntry(service.name, service.version)

  private fun printTool(tool: ToolEntry) =
    printEntry(tool.name, tool.version)

  private fun printEntry(name: String, version: String?) {
    terminal.println(
      buildList {
        add(brightWhite("  $name"))
        version
          ?.let { add(italic(white(it))) }
      }.joinToString(" ")
    )
  }

  private fun printDetectorSection(header: String, technologies: List<Technology>) {
    printSectionHeader(header, technologies.size)
    terminal.println(table {
      column(2) { width = ColumnWidth.Expand() }
      header {
        row("Title", "ID", "URL")
      }
      body {
        technologies.forEach {
          row(
            brightWhite(it.title),
            dim(italic(it.id)),
            it.url
          )
        }

      }
    })
  }

}
