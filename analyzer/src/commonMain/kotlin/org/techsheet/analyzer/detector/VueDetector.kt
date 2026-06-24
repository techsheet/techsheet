package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class VueDetector : AbstractNpmDependencyDetector(
  name = "Vue.js",
  packageName = "vue",
  apply = { result, version -> result.withFramework(FrameworkType.VUE, version) },
)
