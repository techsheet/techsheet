package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class PythonDetector : AbstractLanguageDetector(
  name = "Python",
  type = LanguageType.PYTHON,
  ".py",
)
