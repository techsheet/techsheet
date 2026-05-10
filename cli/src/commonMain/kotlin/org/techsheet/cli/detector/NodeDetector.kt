package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class NodeDetector : Detector(
  "Node.js",
  Matcher.Filename(".nvmrc"),
  Matcher.Filename(".node-version"),
  Matcher.Filename("package.json"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    when (path.name) {
      ".nvmrc", ".node-version" -> result.withTool(
        ToolType.NODE,
        content.value?.trim()?.ifEmpty { null },
      )
      "package.json" -> content.value
        ?.let { text ->
          val version = ENGINES_NODE.find(text)?.groupValues?.getOrNull(1)
            ?.trimStart('^', '~', '>', '=', ' ')
          when {
            version != null -> result.withTool(ToolType.NODE, version)
            NODE_SCRIPT.containsMatchIn(text) -> result.withTool(ToolType.NODE)
            else -> result
          }
        }
        ?: result
      else -> result
    }

  private companion object {
    val ENGINES_NODE = Regex(""""engines"\s*:\s*\{[\s\S]*?"node"\s*:\s*"([^"]+)"""")
    val NODE_SCRIPT = Regex(""":\s*"\s*node(?:\s|")""")
  }
}
