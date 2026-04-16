package org.techsheet.cli.detector

import org.techsheet.cli.domain.TechnologyType

class TailwindDetector : AbstractNpmDependencyDetector(
  "Tailwind CSS", "tailwindcss",
  { sheet, v -> sheet.withTechnology(TechnologyType.TAILWIND, v) },
)
