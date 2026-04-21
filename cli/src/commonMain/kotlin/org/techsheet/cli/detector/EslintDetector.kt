package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class EslintDetector : AbstractNpmDependencyDetector(
  name = "ESLint",
  packageName = "eslint",
  apply = { sheet, version -> sheet.withTool(ToolType.ESLINT, version) },
)
