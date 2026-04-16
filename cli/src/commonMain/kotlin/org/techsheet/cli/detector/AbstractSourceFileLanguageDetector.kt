package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

abstract class AbstractSourceFileLanguageDetector(
  name: String,
  private val type: LanguageType,
  private val sourceExtension: String,
  private val maxDepth: Int = DEFAULT_MAX_DEPTH,
) : Detector(name) {

  final override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(maxDepth)
      .firstOrNull { it.name.endsWith(sourceExtension) }
      ?.also { ctx.log.d("$name source file present: $it") }
      ?.let { sheet.withLanguage(Language(type, detectVersion(ctx))) }
      ?: sheet

  protected abstract fun detectVersion(ctx: AnalyzerContext): String?

  protected fun firstMatchIn(
    ctx: AnalyzerContext,
    predicate: (String) -> Boolean,
    extract: (String) -> String?,
  ): String? = ctx.walk(maxDepth)
    .filter { predicate(it.name) }
    .firstNotNullOfOrNull { ctx.readFileContents(it)?.let(extract) }

  companion object {
    const val DEFAULT_MAX_DEPTH = 8
  }
}
