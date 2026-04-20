package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.FrameworkType

class PlaywrightDetector : AbstractNpmDependencyDetector(
  name = "Playwright",
  packageName = "@playwright/test",
  apply = { sheet, version -> sheet.withFramework(FrameworkType.PLAYWRIGHT, version) },
)
