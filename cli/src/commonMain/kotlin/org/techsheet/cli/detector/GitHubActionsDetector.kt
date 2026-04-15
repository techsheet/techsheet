package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class GitHubActionsDetector : Detector("GitHub Actions") {

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    if (ctx.hasFile(".github/workflows")) sheet.withTool(ToolType.GITHUB_ACTIONS) else sheet
}
