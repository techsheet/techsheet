package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class SvelteDetector : AbstractNpmDependencyDetector(
  "Svelte", "svelte",
  { sheet, v -> sheet.withFramework(FrameworkType.SVELTE, v) },
)
