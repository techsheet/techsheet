package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PythonDetector : AbstractLanguageDetector(
  name = "Python",
  type = LanguageType.PYTHON,
  ".py",
)
