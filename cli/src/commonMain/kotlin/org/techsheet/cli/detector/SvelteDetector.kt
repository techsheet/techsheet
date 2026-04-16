package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class SvelteDetector : AbstractNpmDependencyDetector(
  "Svelte", "svelte",
  { sheet, v -> sheet.withTechnology(TechnologyType.SVELTE, v) },
)
