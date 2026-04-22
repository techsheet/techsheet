package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class CraftCmsDetector : AbstractPhpFrameworkDetector(
  name = "Craft CMS",
  framework = FrameworkType.CRAFT_CMS,
  packageNames = listOf("craftcms/cms"),
)
