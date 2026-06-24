package org.techsheet.analyzer.util

import com.github.ajalt.mordant.rendering.AnsiLevel
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*
import com.github.ajalt.mordant.terminal.Terminal
import org.techsheet.analyzer.VERSION
import org.techsheet.core.Framework
import org.techsheet.core.Language
import org.techsheet.core.Service
import org.techsheet.core.TechSheet
import org.techsheet.core.Tool

class ConsolePrinter(val terminal: Terminal) {

  constructor(color: Boolean) :
    this(Terminal(ansiLevel = if (color) null else AnsiLevel.NONE))

  fun printReport(techSheet: TechSheet) {
    printHeader()

    printSectionHeader("Languages", techSheet.languages.size)
    techSheet.languages
      .forEach { printLanguage(it) }

    printSectionHeader("Frameworks", techSheet.frameworks.size)
    techSheet.frameworks
      .groupBy { it.category }
      .forEach { (category, frameworks) ->
        printCategoryHeader(category ?: "", frameworks.size)
        frameworks.forEach { printFramework(it) }
      }

    printSectionHeader("Services", techSheet.services.size)
    techSheet.services
      .groupBy { it.category }
      .forEach { (category, services) ->
        printCategoryHeader(category ?: "", services.size)
        services.forEach { printService(it) }
      }

    printSectionHeader("Tools", techSheet.tools.size)
    techSheet.tools
      .groupBy { it.category }
      .forEach { (category, tools) ->
        printCategoryHeader(category ?: "", tools.size)
        tools.forEach { printTool(it) }
      }

    printFooter()
  }

  fun printHeader() {
    terminal.println("")
    terminal.println(
      buildList {
        add(cyan("─────"))
        add(bold(brightCyan("TechSheet")))
        add(dim(italic("v${VERSION}")))
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

  private fun printLanguage(lang: Language) =
    printEntry(lang.name, lang.version)

  private fun printFramework(framework: Framework) =
    printEntry(framework.name, framework.version)

  private fun printService(service: Service) =
    printEntry(service.name, service.version)

  private fun printTool(tool: Tool) =
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

}
