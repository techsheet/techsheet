package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class NpmDetector : AbstractFilePresentDetector(
  "NPM",
  { it.withTool(ToolType.NPM) },
  "package.json",
  "package-lock.json",
  "npm-shrinkwrap.json",
  ) {
  // In monorepos package.json / package-lock.json can live under packages/*, apps/*, etc.
  override val depth = 3
}
