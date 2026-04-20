package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class TailwindDetector : AbstractNpmDependencyDetector(
  name = "Tailwind CSS",
  packageName = "tailwindcss",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.TAILWIND, version) },
)
