package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class NpmDetector : Detector(
  "NPM",
  Matcher.Filename("package.json"),
  Matcher.Filename("package-lock.json"),
  Matcher.Filename("npm-shrinkwrap.json"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean =
    result.tools.any { it.type == ToolType.NPM && it.version != null }

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.NPM, version = versionFor(path.name, content))

  private fun versionFor(name: String, content: Lazy<String?>): String? =
    name.takeIf { it == "package.json" }
      ?.let { content.value }
      ?.let(ENGINES_NPM::find)
      ?.groupValues
      ?.getOrNull(1)
      ?.trimStart('^', '~', '>', '=', ' ')
      ?.ifEmpty { null }

  private companion object {
    val ENGINES_NPM =
      Regex(""""engines"\s*:\s*\{[^{}]*?"npm"\s*:\s*"([^"]+)"""")
  }
}
