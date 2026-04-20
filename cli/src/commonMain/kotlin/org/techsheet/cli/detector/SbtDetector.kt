package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class SbtDetector : Detector(
  "sbt",
  Matcher.Filename(BUILD_SBT),
  Matcher.Filename(BUILD_PROPERTIES),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    when (path.name) {
      BUILD_SBT -> sheet.withTool(ToolType.SBT)
      BUILD_PROPERTIES -> versionFrom(content.value)
        ?.let { sheet.withTool(ToolType.SBT, it) }
        ?: sheet
      else -> sheet
    }

  private fun versionFrom(text: String?): String? =
    text?.let { SBT_VERSION.find(it)?.groupValues?.getOrNull(1) }

  private companion object {
    const val BUILD_SBT = "build.sbt"
    const val BUILD_PROPERTIES = "build.properties"
    val SBT_VERSION = Regex("""^\s*sbt\.version\s*=\s*(\S+)""", RegexOption.MULTILINE)
  }
}
