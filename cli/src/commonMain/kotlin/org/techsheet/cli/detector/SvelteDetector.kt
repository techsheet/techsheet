package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SvelteDetector : AbstractNpmDependencyDetector(
  name = "Svelte",
  packageName = "svelte",
  apply = { result, version -> result.withFramework(FrameworkType.SVELTE, version) },
)
