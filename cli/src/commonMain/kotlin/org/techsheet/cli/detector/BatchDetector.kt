package org.techsheet.cli.detector

import org.techsheet.cli.domain.LanguageType

class BatchDetector : AbstractLanguageDetector(
  name = "Batch",
  type = LanguageType.BATCH,
  ".bat", ".cmd",
) {

  override val skipFiles: List<String> = listOf("gradlew.bat", "mvnw.bat", "mvnw.cmd")
}
