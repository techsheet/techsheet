package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class EslintDetector : AbstractNpmDependencyDetector(
  name = "ESLint",
  packageName = "eslint",
  apply = { result, version -> result.withTool(ToolType.ESLINT, version) },
)
