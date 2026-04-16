package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.LanguageType

class TypeScriptDetector : AbstractSourceFileLanguageDetector(
  name = "TypeScript",
  type = LanguageType.TYPESCRIPT,
  sourceExtension = TS_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? =
    probePackageJson(ctx) ?: probeToolVersions(ctx)

  private fun probePackageJson(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == "package.json" }) { content ->
      PACKAGE_JSON_TYPESCRIPT.find(content)?.groupValues?.get(1)?.trimStart('^', '~', '>', '=', ' ')
    }

  private fun probeToolVersions(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".tool-versions" }) { content ->
      content.lineSequence().firstNotNullOfOrNull {
        TOOL_VERSIONS_LINE.find(it)?.groupValues?.get(1)
      }
    }

  companion object {
    private const val TS_EXT = ".ts"

    private val PACKAGE_JSON_TYPESCRIPT =
      Regex(""""typescript"\s*:\s*"([^"]+)"""")
    private val TOOL_VERSIONS_LINE =
      Regex("""^\s*typescript\s+(\S+)""")
  }
}
