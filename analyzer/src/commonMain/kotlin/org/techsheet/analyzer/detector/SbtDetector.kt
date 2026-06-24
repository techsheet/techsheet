package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.Matcher
import org.techsheet.analyzer.domain.ToolType

class SbtDetector : Detector(
  "sbt",
  Matcher.Filename(BUILD_SBT),
  Matcher.Filename(BUILD_PROPERTIES),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    when (path.name) {
      BUILD_SBT -> result.withTool(ToolType.SBT)
      BUILD_PROPERTIES -> versionFrom(content.value)
        ?.let { result.withTool(ToolType.SBT, it) }
        ?: result
      else -> result
    }

  private fun versionFrom(text: String?): String? =
    text?.let { SBT_VERSION.find(it)?.groupValues?.getOrNull(1) }

  private companion object {
    const val BUILD_SBT = "build.sbt"
    const val BUILD_PROPERTIES = "build.properties"
    val SBT_VERSION = Regex("""^\s*sbt\.version\s*=\s*(\S+)""", RegexOption.MULTILINE)
  }
}
