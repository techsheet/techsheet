package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class EditorConfigDetector : AbstractFilePresentDetector(
  "EditorConfig",
  { it.withTool(ToolType.EDITORCONFIG) },
  ".editorconfig",
  ) {
  // .editorconfig sits at the project root
  override val depth = 0
}
