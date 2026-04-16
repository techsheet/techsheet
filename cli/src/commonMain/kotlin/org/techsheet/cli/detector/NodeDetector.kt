package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class NodeDetector : Detector("Node.js") {

  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet {
    val version = versionFromNvmrc(ctx) ?: versionFromEngines(ctx)
    return if (version != null || hasNodeScript(ctx)) sheet.withTool(ToolType.NODE, version) else sheet
  }

  private fun versionFromNvmrc(ctx: AnalyzerContext): String? =
    ctx.walk(depth)
      .firstOrNull { it.name == ".nvmrc" || it.name == ".node-version" }
      ?.let(ctx::readFileContents)
      ?.trim()
      ?.ifEmpty { null }

  private fun versionFromEngines(ctx: AnalyzerContext): String? =
    packageJsonContents(ctx)
      .firstNotNullOfOrNull { ENGINES_NODE.find(it)?.groupValues?.get(1) }
      ?.trimStart('^', '~', '>', '=', ' ')

  private fun hasNodeScript(ctx: AnalyzerContext): Boolean =
    packageJsonContents(ctx).any(NODE_SCRIPT::containsMatchIn)

  private fun packageJsonContents(ctx: AnalyzerContext): Sequence<String> =
    ctx.walk(depth)
      .filter { it.name == "package.json" }
      .mapNotNull(ctx::readFileContents)

  companion object {
    private val ENGINES_NODE = Regex(""""engines"\s*:\s*\{[\s\S]*?"node"\s*:\s*"([^"]+)"""")
    private val NODE_SCRIPT = Regex(""":\s*"\s*node(?:\s|")""")
  }
}
