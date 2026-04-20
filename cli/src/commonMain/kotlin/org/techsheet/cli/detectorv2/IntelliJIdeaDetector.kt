package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class IntelliJIdeaDetector : Detector("IntelliJ IDEA") {

  override val matchers: List<Matcher> = listOf(
    Matcher.DirectoryAt(".idea"),
    Matcher.Extension(".iml"),
  )

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.INTELLIJ_IDEA)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.INTELLIJ_IDEA)
}
