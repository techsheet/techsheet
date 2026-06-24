package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class TailwindDetector : AbstractNpmDependencyDetector(
  name = "Tailwind CSS",
  packageName = "tailwindcss",
  apply = { result, version -> result.withFramework(FrameworkType.TAILWIND, version) },
)
