package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class RenovateDetector : Detector("Renovate") {

  override val matchers: List<Matcher> = listOf(
    Matcher.Filename("renovate.json"),
    Matcher.Filename("renovate.json5"),
    Matcher.Filename(".renovaterc"),
    Matcher.Filename(".renovaterc.json"),
    Matcher.Filename(".renovaterc.json5"),
  )

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.RENOVATE)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.RENOVATE)
}
