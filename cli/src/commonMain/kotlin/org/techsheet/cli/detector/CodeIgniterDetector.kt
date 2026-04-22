package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class CodeIgniterDetector : AbstractPhpDependencyDetector(
  name = "CodeIgniter",
  framework = FrameworkType.CODEIGNITER,
  packageNames = listOf("codeigniter4/framework"),
)
