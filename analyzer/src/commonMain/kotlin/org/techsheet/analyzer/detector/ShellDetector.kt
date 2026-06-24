package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class ShellDetector : AbstractLanguageDetector(
  name = "Shell",
  type = LanguageType.SHELL,
  ".sh", ".bash", ".zsh",
)
