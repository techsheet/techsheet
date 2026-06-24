package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class GeminiDetector : Detector(
  "Gemini",
  Matcher.Filename("GEMINI.md"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.GEMINI)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.GEMINI)
}
