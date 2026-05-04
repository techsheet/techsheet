package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ShellDetector : AbstractLanguageDetector(
  name = "Shell",
  type = LanguageType.SHELL,
  ".sh", ".bash", ".zsh",
)
