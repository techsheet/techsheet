package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class GitDetector : Detector("Git") {

  override val matchers: List<Matcher> = listOf(
    Matcher.DirectoryAt(".git"),
    Matcher.Filename(".gitignore"),
  )

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.GIT)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.GIT)
}
