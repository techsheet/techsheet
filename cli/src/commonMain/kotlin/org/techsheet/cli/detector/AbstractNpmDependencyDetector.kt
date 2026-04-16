package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet

abstract class AbstractNpmDependencyDetector(
  name: String,
  private val packageName: String,
  private val apply: (TechSheet, String?) -> TechSheet,
) : Detector(name) {

  protected open val depth: Int = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name == "package.json" }
      .mapNotNull(ctx::readFileContents)
      .firstNotNullOfOrNull { versionRegex.find(it)?.groupValues?.get(1) }
      ?.trimStart('^', '~', '>', '=', ' ')
      ?.also { ctx.log.d { "$name: '$packageName' present in package.json" } }
      ?.let { apply(sheet, it.ifEmpty { null }) }
      ?: sheet

  private val versionRegex = Regex(""""${Regex.escape(packageName)}"\s*:\s*"([^"]+)"""")
}
