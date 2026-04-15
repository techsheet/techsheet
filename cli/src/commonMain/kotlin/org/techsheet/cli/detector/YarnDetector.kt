package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class YarnDetector : AbstractFilePresentDetector(
  "Yarn",
  { it.withTool(ToolType.YARN) },
  "yarn.lock",
  ".yarnrc",
  ".yarnrc.yml",
  ) {
  // In monorepos lock/config files can live under packages/*, apps/*, etc.
  override val depth = 3
}
