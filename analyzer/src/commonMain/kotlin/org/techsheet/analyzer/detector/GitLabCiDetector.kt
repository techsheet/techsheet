package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class GitLabCiDetector : Detector("GitLab CI", Matcher.Filename(".gitlab-ci.yml")) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.GITLAB_CI)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.GITLAB_CI)
}
