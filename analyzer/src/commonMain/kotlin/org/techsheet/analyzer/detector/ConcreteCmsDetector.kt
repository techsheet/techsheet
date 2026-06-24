package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class ConcreteCmsDetector : AbstractPhpFrameworkDetector(
  name = "Concrete CMS",
  framework = FrameworkType.CONCRETE_CMS,
  packageNames = listOf("concretecms/concretecms"),
)
