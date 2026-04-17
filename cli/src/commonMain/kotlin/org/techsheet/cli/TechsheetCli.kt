package org.techsheet.cli

import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.core.PrintHelpMessage
import com.github.ajalt.clikt.parameters.options.versionOption
import org.techsheet.cli.CLI_VERSION

class TechsheetCli : CoreCliktCommand(name = "techsheet-cli") {

  init {
    versionOption(CLI_VERSION)
  }

  override fun run() {
    if (currentContext.invokedSubcommand == null) {
      throw PrintHelpMessage(currentContext, error = false)
    }
  }
}
