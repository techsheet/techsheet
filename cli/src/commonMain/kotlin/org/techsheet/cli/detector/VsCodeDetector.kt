package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class VsCodeDetector : Detector("Visual Studio Code") {

  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    if (hasVsCodeMarker(ctx)) sheet.withTool(ToolType.VS_CODE) else sheet

  // .vscode/ lives at the project root; *.code-workspace files can sit at root
  // or in a sub-project in multi-root setups.
  private fun hasVsCodeMarker(ctx: AnalyzerContext): Boolean =
    ctx.hasFile(".vscode") || ctx.walk(depth).any { it.name.endsWith(".code-workspace") }
}
