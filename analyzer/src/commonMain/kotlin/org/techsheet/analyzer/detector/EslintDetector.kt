package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.ToolType

class EslintDetector : AbstractNpmDependencyDetector(
  name = "ESLint",
  packageName = "eslint",
  apply = { result, version -> result.withTool(ToolType.ESLINT, version) },
)
