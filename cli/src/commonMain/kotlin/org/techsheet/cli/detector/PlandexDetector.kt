package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class PlandexDetector : Detector(
  "Plandex",
  Matcher.DirectoryAt(".plandex"),
) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.PLANDEX)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.PLANDEX)
}
