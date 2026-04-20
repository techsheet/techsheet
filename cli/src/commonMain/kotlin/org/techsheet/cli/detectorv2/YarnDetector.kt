package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class YarnDetector : Detector("Yarn") {

  override val matchers: List<Matcher> = listOf(
    Matcher.Filename("yarn.lock"),
    Matcher.Filename(".yarnrc"),
    Matcher.Filename(".yarnrc.yml"),
  )

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.YARN)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.YARN)
}
