package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class CraftCmsDetector : AbstractPhpFrameworkDetector(
  name = "Craft CMS",
  framework = FrameworkType.CRAFT_CMS,
  packageNames = listOf("craftcms/cms"),
)
