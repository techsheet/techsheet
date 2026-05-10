package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class VueDetector : AbstractNpmDependencyDetector(
  name = "Vue.js",
  packageName = "vue",
  apply = { result, version -> result.withFramework(FrameworkType.VUE, version) },
)
