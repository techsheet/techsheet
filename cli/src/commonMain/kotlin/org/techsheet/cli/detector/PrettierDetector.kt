package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class PrettierDetector : AbstractNpmDependencyDetector(
  name = "Prettier",
  packageName = "prettier",
  apply = { sheet, version -> sheet.withTool(ToolType.PRETTIER, version) },
)
