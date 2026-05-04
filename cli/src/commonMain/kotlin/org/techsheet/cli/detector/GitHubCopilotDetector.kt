package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class GitHubCopilotDetector : Detector(
  "GitHub Copilot",
  Matcher.FileAt(".github", "copilot-instructions.md"),
) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.GITHUB_COPILOT)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.GITHUB_COPILOT)
}
