package org.techsheet.cli

import com.github.ajalt.clikt.core.CoreCliktCommand
import com.github.ajalt.clikt.core.PrintHelpMessage

class TechsheetCli : CoreCliktCommand(name = "techsheet-cli") {

  override fun run() {
    if (currentContext.invokedSubcommand == null) {
      throw PrintHelpMessage(currentContext, error = false)
    }
  }
}
