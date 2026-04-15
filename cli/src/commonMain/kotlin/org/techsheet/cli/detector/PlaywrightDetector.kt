package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class PlaywrightDetector : Detector("Playwright") {

  // Monorepos commonly keep e2e suites under apps/*/e2e, packages/*, tests/, etc.
  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .firstOrNull { it.name in CONFIG_FILES }
      ?.also { ctx.log.d { "Playwright: '${it.name}' present" } }
      ?.let { sheet.withTechnology(TechnologyType.PLAYWRIGHT, version = detectVersion(ctx)) }
      ?: sheet

  private fun detectVersion(ctx: AnalyzerContext): String? =
    ctx.walk(depth)
      .filter { it.name == "package.json" }
      .firstNotNullOfOrNull { ctx.readFileContents(it) }
      ?.let { content ->
        PLAYWRIGHT_TEST.find(content)?.groupValues?.get(1)
          ?: PLAYWRIGHT.find(content)?.groupValues?.get(1)
      }
      ?.trimStart('^', '~', '>', '=', ' ')

  companion object {
    private val CONFIG_FILES = setOf(
      "playwright.config.ts",
      "playwright.config.js",
      "playwright.config.mjs",
      "playwright.config.cjs",
    )

    private val PLAYWRIGHT_TEST = Regex(""""@playwright/test"\s*:\s*"([^"]+)"""")
    private val PLAYWRIGHT = Regex(""""playwright"\s*:\s*"([^"]+)"""")
  }
}
