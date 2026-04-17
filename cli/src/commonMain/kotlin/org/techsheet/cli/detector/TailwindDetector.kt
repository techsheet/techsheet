package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class TailwindDetector : AbstractNpmDependencyDetector(
  "Tailwind CSS", "tailwindcss",
  { sheet, v -> sheet.withFramework(FrameworkType.TAILWIND, v) },
)
