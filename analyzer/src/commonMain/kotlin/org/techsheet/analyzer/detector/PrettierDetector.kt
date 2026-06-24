package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.ToolType

class PrettierDetector : AbstractNpmDependencyDetector(
  name = "Prettier",
  packageName = "prettier",
  apply = { result, version -> result.withTool(ToolType.PRETTIER, version) },
)
