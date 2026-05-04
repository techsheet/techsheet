package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class WindsurfDetector : Detector(
  "Windsurf",
  Matcher.DirectoryAt(".windsurf"),
  Matcher.Filename(".windsurfrules"),
) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.WINDSURF)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.WINDSURF)
}
