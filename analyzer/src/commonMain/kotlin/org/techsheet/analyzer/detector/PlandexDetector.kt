package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class PlandexDetector : Detector(
  "Plandex",
  Matcher.DirectoryAt(".plandex"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.PLANDEX)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.PLANDEX)
}
