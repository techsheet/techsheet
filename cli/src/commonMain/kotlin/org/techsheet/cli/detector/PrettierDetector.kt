package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class PrettierDetector : AbstractNpmDependencyDetector(
  "Prettier", "prettier",
  { sheet, v -> sheet.withTool(ToolType.PRETTIER, v) },
)
