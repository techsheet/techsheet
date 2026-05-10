package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class GitHubCopilotDetector : Detector(
  "GitHub Copilot",
  Matcher.FileAt(".github", "copilot-instructions.md"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.GITHUB_COPILOT)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.GITHUB_COPILOT)
}
