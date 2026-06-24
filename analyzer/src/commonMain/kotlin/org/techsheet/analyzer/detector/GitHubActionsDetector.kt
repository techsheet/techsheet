package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class GitHubActionsDetector : Detector("GitHub Actions", Matcher.DirectoryAt(".github", "workflows")) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.GITHUB_ACTIONS)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.GITHUB_ACTIONS)
}
