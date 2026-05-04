package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PowerShellDetector : AbstractLanguageDetector(
  name = "PowerShell",
  type = LanguageType.POWERSHELL,
  ".ps1", ".psm1",
)
