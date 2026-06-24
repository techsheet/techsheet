package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class MagentoDetector : AbstractPhpFrameworkDetector(
  name = "Magento",
  framework = FrameworkType.MAGENTO,
  packageNames = listOf(
    "magento/product-community-edition",
    "magento/product-enterprise-edition",
  ),
)
