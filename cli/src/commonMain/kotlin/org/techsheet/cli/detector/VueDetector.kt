package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class VueDetector : AbstractNpmDependencyDetector(
  "Vue.js", "vue",
  { sheet, v -> sheet.withTechnology(TechnologyType.VUE, v) },
)
