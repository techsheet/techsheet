package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SvelteDetector : AbstractNpmDependencyDetector(
  name = "Svelte",
  packageName = "svelte",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.SVELTE, version) },
)
