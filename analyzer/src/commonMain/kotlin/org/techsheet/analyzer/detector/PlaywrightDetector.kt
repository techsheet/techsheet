package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.FrameworkType

class PlaywrightDetector : AbstractNpmDependencyDetector(
  name = "Playwright",
  packageName = "@playwright/test",
  apply = { result, version -> result.withFramework(FrameworkType.PLAYWRIGHT, version) },
)
