package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class EslintDetector : AbstractNpmDependencyDetector(
  "ESLint", "eslint",
  { sheet, v -> sheet.withTool(ToolType.ESLINT, v) },
)
