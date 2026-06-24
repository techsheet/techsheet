package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class RenovateDetector : Detector(
  "Renovate",
  Matcher.Filename("renovate.json"),
  Matcher.Filename("renovate.json5"),
  Matcher.Filename(".renovaterc"),
  Matcher.Filename(".renovaterc.json"),
  Matcher.Filename(".renovaterc.json5"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.RENOVATE)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.RENOVATE)
}
