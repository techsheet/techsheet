package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class BatchDetector : AbstractSourceFileLanguageDetector(
  name = "Batch",
  type = LanguageType.BATCH,
  ".bat", ".cmd",
)
