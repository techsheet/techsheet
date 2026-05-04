package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PowerShellDetector : AbstractSourceFileLanguageDetector(
  name = "PowerShell",
  type = LanguageType.POWERSHELL,
  ".ps1", ".psm1",
)
