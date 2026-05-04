package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class KiroDetector : Detector(
  "Kiro",
  Matcher.DirectoryAt(".kiro"),
) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.KIRO)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.KIRO)
}
