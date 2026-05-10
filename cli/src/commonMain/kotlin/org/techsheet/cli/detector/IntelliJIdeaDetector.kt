package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class IntelliJIdeaDetector : Detector(
  "IntelliJ IDEA",
  Matcher.DirectoryAt(".idea"),
  Matcher.Extension(".iml"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.INTELLIJ_IDEA)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.INTELLIJ_IDEA)
}
