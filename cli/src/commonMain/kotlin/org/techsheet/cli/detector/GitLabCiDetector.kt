package org.techsheet.cli.detector

import org.techsheet.cli.domain.ToolType

class GitLabCiDetector : AbstractFilePresentDetector(
  "GitLab CI",
  { it.withTool(ToolType.GITLAB_CI) },
  ".gitlab-ci.yml",
  ) {
  // .gitlab-ci.yml is always at project root
  override val depth = 0
}
