package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class CodeIgniterDetector : AbstractPhpFrameworkDetector(
  name = "CodeIgniter",
  framework = FrameworkType.CODEIGNITER,
  packageNames = listOf("codeigniter4/framework"),
)
