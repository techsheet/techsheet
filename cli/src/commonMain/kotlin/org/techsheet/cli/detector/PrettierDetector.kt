package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class PrettierDetector : AbstractNpmDependencyDetector(
  name = "Prettier",
  packageName = "prettier",
  apply = { result, version -> result.withTool(ToolType.PRETTIER, version) },
)
