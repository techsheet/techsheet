package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.LanguageType

class PythonDetector : AbstractSourceFileLanguageDetector(
  name = "Python",
  type = LanguageType.PYTHON,
  sourceExtension = ".py",
)
