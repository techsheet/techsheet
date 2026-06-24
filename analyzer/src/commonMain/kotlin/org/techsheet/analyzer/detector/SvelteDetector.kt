package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class SvelteDetector : AbstractNpmDependencyDetector(
  name = "Svelte",
  packageName = "svelte",
  apply = { result, version -> result.withFramework(FrameworkType.SVELTE, version) },
)
