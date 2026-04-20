package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class PythonDetector : AbstractSourceFileLanguageDetector(
  name = "Python",
  type = LanguageType.PYTHON,
  sourceExtension = ".py",
)
