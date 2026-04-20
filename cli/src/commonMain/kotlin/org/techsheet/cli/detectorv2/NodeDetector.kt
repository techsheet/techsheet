package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class NodeDetector : Detector(
  "Node.js",
  Matcher.Filename(".nvmrc"),
  Matcher.Filename(".node-version"),
  Matcher.Filename("package.json"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    when (path.name) {
      ".nvmrc", ".node-version" -> sheet.withTool(
        ToolType.NODE,
        content.value?.trim()?.ifEmpty { null },
      )
      "package.json" -> content.value
        ?.let { text ->
          val version = ENGINES_NODE.find(text)?.groupValues?.getOrNull(1)
            ?.trimStart('^', '~', '>', '=', ' ')
          when {
            version != null -> sheet.withTool(ToolType.NODE, version)
            NODE_SCRIPT.containsMatchIn(text) -> sheet.withTool(ToolType.NODE)
            else -> sheet
          }
        }
        ?: sheet
      else -> sheet
    }

  private companion object {
    val ENGINES_NODE = Regex(""""engines"\s*:\s*\{[\s\S]*?"node"\s*:\s*"([^"]+)"""")
    val NODE_SCRIPT = Regex(""":\s*"\s*node(?:\s|")""")
  }
}
