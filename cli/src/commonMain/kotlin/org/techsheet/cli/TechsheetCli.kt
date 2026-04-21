package org.techsheet.cli

import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.core.PrintHelpMessage
import com.github.ajalt.clikt.parameters.options.versionOption

class TechsheetCli : CoreCliktCommand(name = "techsheet-cli") {

  init {
    versionOption(CLI_VERSION)
  }

  override fun help(context: Context): String = """
    Detects and report technologies used in a software project, initialize new projects and list detectors.

    TechSheet inspects a project directory and identifies the languages, frameworks, services, and tools in use. Results are rendered to the console or exported as YAML, JSON, or Markdown.

    Run `techsheet analyze --help` to get started, or `techsheet detectors` to see everything the tool can detect.
  """.trimIndent()

  override fun run() {
    if (currentContext.invokedSubcommand == null) {
      throw PrintHelpMessage(currentContext, error = false)
    }
  }
}
