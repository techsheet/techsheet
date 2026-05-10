package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class EditorConfigDetector : Detector("EditorConfig", Matcher.Filename(".editorconfig")) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.EDITORCONFIG)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.EDITORCONFIG)
}
