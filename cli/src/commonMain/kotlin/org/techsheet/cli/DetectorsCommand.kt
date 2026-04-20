package org.techsheet.cli

import com.github.ajalt.clikt.core.CoreCliktCommand
import org.techsheet.cli.detector.Detectors

class DetectorsCommand : CoreCliktCommand(name = "detectors") {

  override fun run() {
    Detectors.ALL.forEach { println(it.name) }
  }
}
