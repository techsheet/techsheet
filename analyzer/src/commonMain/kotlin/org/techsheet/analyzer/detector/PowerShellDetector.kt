package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class PowerShellDetector : AbstractLanguageDetector(
  name = "PowerShell",
  type = LanguageType.POWERSHELL,
  ".ps1", ".psm1",
)
