package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class CodeOwnersDetector : AbstractFilePresentDetector(
  "CODEOWNERS",
  { it.withTool(ToolType.CODEOWNERS) },
  "CODEOWNERS",
  ) {
  // CODEOWNERS lives at the project root (or under .github/, .gitlab/, docs/)
  override val depth = 1
}
