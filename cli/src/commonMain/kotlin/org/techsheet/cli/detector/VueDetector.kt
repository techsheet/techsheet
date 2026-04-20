package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class VueDetector : AbstractNpmDependencyDetector(
  name = "Vue.js",
  packageName = "vue",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.VUE, version) },
)
