package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class IntelliJIdeaDetector : Detector("IntelliJ IDEA") {

  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    if (hasIdeaMarker(ctx)) sheet.withTool(ToolType.INTELLIJ_IDEA) else sheet

  // Two independent markers: the .idea/ project dir (at root) and per-module *.iml files
  // (which live at module roots and survive even when .idea/ is gitignored).
  private fun hasIdeaMarker(ctx: AnalyzerContext): Boolean =
    ctx.hasFile(".idea") || ctx.walk(depth).any { it.name.endsWith(".iml") }
}
