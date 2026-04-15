package org.techsheet.cli

import com.github.ajalt.clikt.core.CoreCliktCommand

class DetectorsCommand : CoreCliktCommand(name = "detectors") {

  override fun run() {
    Analyzer.ALL_DETECTORS.forEach { println(it.name) }
  }
}
