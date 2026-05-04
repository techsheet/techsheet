package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class AmazonQDetector : Detector(
  "Amazon Q",
  Matcher.DirectoryAt(".amazonq"),
) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.AMAZON_Q)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.AMAZON_Q)
}
