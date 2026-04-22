package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class ConcreteCmsDetector : AbstractPhpFrameworkDetector(
  name = "Concrete CMS",
  framework = FrameworkType.CONCRETE_CMS,
  packageNames = listOf("concretecms/concretecms"),
)
