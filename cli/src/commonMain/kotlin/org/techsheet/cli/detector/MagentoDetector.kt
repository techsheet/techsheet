package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class MagentoDetector : AbstractPhpFrameworkDetector(
  name = "Magento",
  framework = FrameworkType.MAGENTO,
  packageNames = listOf(
    "magento/product-community-edition",
    "magento/product-enterprise-edition",
  ),
)
