package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class AngularDetector : Detector("Angular") {

  // Monorepos can hold multiple Angular apps under apps/*, projects/*, etc.
  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .firstOrNull { it.name == "angular.json" }
      ?.also { ctx.log.d { "Angular: '${it.name}' present" } }
      ?.let { sheet.withTechnology(TechnologyType.ANGULAR, version = detectVersion(ctx)) }
      ?: sheet

  private fun detectVersion(ctx: AnalyzerContext): String? =
    ctx.walk(depth)
      .filter { it.name == "package.json" }
      .firstNotNullOfOrNull { ctx.readFileContents(it) }
      ?.let { content -> ANGULAR_CORE.find(content)?.groupValues?.get(1) }
      ?.trimStart('^', '~', '>', '=', ' ')

  companion object {
    private val ANGULAR_CORE = Regex(""""@angular/core"\s*:\s*"([^"]+)"""")
  }
}
