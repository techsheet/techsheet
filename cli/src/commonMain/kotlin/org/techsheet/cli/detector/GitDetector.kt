package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class GitDetector : AbstractFilePresentDetector(
  "Git",
  { it.withTool(ToolType.GIT) },
  ".git",
  ".gitignore",
) {
  override val depth = 0
}
