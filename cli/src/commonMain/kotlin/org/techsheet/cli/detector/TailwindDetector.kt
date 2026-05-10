package org.techsheet.cli.detector

import org.techsheet.cli.domain.FrameworkType

class TailwindDetector : AbstractNpmDependencyDetector(
  name = "Tailwind CSS",
  packageName = "tailwindcss",
  apply = { result, version -> result.withFramework(FrameworkType.TAILWIND, version) },
)
