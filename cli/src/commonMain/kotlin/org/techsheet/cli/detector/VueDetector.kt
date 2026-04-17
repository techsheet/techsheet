package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class VueDetector : AbstractNpmDependencyDetector(
  "Vue.js", "vue",
  { sheet, v -> sheet.withFramework(FrameworkType.VUE, v) },
)
