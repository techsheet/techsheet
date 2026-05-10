package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class CodeiumDetector : Detector(
  "Codeium",
  Matcher.DirectoryAt(".codeium"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean = result.hasTool(ToolType.CODEIUM)

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.CODEIUM)
}
