package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class CodeOwnersDetector : Detector("CODEOWNERS", Matcher.Filename("CODEOWNERS")) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.CODEOWNERS)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.CODEOWNERS)
}
