package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class NpmDetector : Detector("NPM") {

  override val matchers: List<Matcher> = listOf(
    Matcher.Filename("package.json"),
    Matcher.Filename("package-lock.json"),
    Matcher.Filename("npm-shrinkwrap.json"),
  )

  override fun skipIf(path: Path, sheet: TechSheet): Boolean =
    sheet.tools.any { it.type == ToolType.NPM && it.version != null }

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withTool(ToolType.NPM, version = versionFor(path.name, content))

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
