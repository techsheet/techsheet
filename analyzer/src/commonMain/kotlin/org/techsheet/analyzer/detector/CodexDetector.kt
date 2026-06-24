package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class CodexDetector : Detector(
  "OpenAI Codex",
  Matcher.DirectoryAt(".codex"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.CODEX)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.CODEX)
}
