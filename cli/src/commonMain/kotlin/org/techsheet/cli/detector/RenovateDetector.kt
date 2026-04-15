package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class RenovateDetector : AbstractFilePresentDetector(
  "Renovate",
  { it.withTool(ToolType.RENOVATE) },
  "renovate.json",
  "renovate.json5",
  ".renovaterc",
  ".renovaterc.json",
  ".renovaterc.json5",
  ) {
  // Renovate config lives at the project root or under .github/ / .gitlab/
  override val depth = 1
}
