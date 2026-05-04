package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class ShellDetector : AbstractSourceFileLanguageDetector(
  name = "Shell",
  type = LanguageType.SHELL,
  ".sh", ".bash", ".zsh",
)
