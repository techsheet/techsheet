package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectedLanguage
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.DetectionResult

class TypeScriptVersionDetector : Detector(
  "TypeScript (version)",
  Matcher.Filename("package.json"),
  Matcher.Filename(".tool-versions"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { result.withLanguage(DetectedLanguage(LanguageType.TYPESCRIPT, it)) }
      ?: result

  private fun extractVersion(filename: String, text: String): String? = when (filename) {
    "package.json" -> PACKAGE_JSON_TYPESCRIPT.find(text)?.groupValues?.getOrNull(1)
      ?.trimStart('^', '~', '>', '=', ' ')
    ".tool-versions" -> text.lineSequence()
      .firstNotNullOfOrNull { TOOL_VERSIONS_LINE.find(it)?.groupValues?.getOrNull(1) }
    else -> null
  }

  private companion object {
    val PACKAGE_JSON_TYPESCRIPT = Regex(""""typescript"\s*:\s*"([^"]+)"""")
    val TOOL_VERSIONS_LINE = Regex("""^\s*typescript\s+(\S+)""")
  }
}
