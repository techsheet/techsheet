package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class EditorConfigDetector : Detector("EditorConfig") {

  override val matchers: List<Matcher> = listOf(Matcher.Filename(".editorconfig"))

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasTool(ToolType.EDITORCONFIG)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.EDITORCONFIG)
}
