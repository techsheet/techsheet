package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class SbtDetector : Detector("sbt") {

  // Multi-project sbt builds can keep sub-module build.sbt files under sub-dirs.
  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .firstOrNull { it.name == "build.sbt" }
      ?.also { ctx.log.d { "sbt: '${it.name}' present" } }
      ?.let { sheet.withTool(ToolType.SBT, version = detectVersion(ctx)) }
      ?: sheet

  private fun detectVersion(ctx: AnalyzerContext): String? =
    ctx.walk(depth)
      .filter { it.name == "build.properties" }
      .firstNotNullOfOrNull { ctx.readFileContents(it) }
      ?.let { SBT_VERSION.find(it)?.groupValues?.get(1) }

  companion object {
    private val SBT_VERSION = Regex("""^\s*sbt\.version\s*=\s*(\S+)""", RegexOption.MULTILINE)
  }
}
