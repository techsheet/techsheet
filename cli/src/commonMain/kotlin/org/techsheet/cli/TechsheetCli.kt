package org.techsheet.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.PrintHelpMessage
import com.github.ajalt.clikt.parameters.options.versionOption

class TechsheetCli : CliktCommand(name = "techsheet") {

  init {
    versionOption(CLI_VERSION)
  }

  override fun help(context: Context): String = """
    Detects and reports technical insights about software projects in an automated, structured, uniform manner.

    Run `${commandName} init` to get started, or `${commandName} detectors` to see everything the tool can detect. To
    just try the analyzer without setting up a project, run `${commandName} analyze -r`.

    For full documentation, run `${commandName} {subcdommand} --help` or visit https://techsheet.org/cli.
  """.trimIndent()

  override fun run() {
    if (currentContext.invokedSubcommand == null) {
      throw PrintHelpMessage(currentContext, error = false)
    }
  }
}
