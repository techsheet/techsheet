package org.techsheet.analyzer.detector

import org.techsheet.analyzer.domain.LanguageType

class BatchDetector : AbstractLanguageDetector(
  name = "Batch",
  type = LanguageType.BATCH,
  ".bat", ".cmd",
) {

  override val skipFiles: List<String> = listOf("gradlew.bat", "mvnw.bat", "mvnw.cmd")
}
