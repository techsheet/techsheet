package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class YarnDetector : Detector(
  "Yarn",
  Matcher.Filename("yarn.lock"),
  Matcher.Filename(".yarnrc"),
  Matcher.Filename(".yarnrc.yml"),
  Matcher.Filename("package.json"),
) {

  override fun skipIf(path: Path, result: DetectionResult): Boolean =
    result.tools.any { it.type == ToolType.YARN && it.version != null }

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    when (path.name) {
      "yarn.lock", ".yarnrc" -> result.withTool(ToolType.YARN)
      ".yarnrc.yml" -> result.withTool(ToolType.YARN, version = versionFromYarnrcYml(content.value))
      "package.json" -> versionFromPackageJson(content.value)
        ?.let { result.withTool(ToolType.YARN, version = it) }
        ?: result
      else -> result
    }

  private fun versionFromYarnrcYml(text: String?): String? =
    text?.let(YARN_PATH::find)?.groupValues?.getOrNull(1)

  private fun versionFromPackageJson(text: String?): String? = text?.let {
    PACKAGE_MANAGER.find(it)?.groupValues?.getOrNull(1)
      ?: ENGINES_YARN.find(it)?.groupValues?.getOrNull(1)
        ?.trimStart('^', '~', '>', '=', ' ')
        ?.ifEmpty { null }
  }

  private companion object {
    val YARN_PATH = Regex("""yarnPath\s*:\s*\S*yarn-(\d+(?:\.\d+)*)\.cjs""")
    val PACKAGE_MANAGER = Regex(""""packageManager"\s*:\s*"yarn@([^"+]+)""")
    val ENGINES_YARN = Regex(""""engines"\s*:\s*\{[^{}]*?"yarn"\s*:\s*"([^"]+)"""")
  }
}
