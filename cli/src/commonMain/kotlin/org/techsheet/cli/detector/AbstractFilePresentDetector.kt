package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet


/**
 * Detector that scans for a specifically named file in the project
 *
 * @param name The name of the detector
 * @param fileNames The name of the file(s), i.e. ".gitlab-ci.yml", "CODEOWNERS"
 */
abstract class AbstractFilePresentDetector(
  name: String,
  private val block: (TechSheet) -> TechSheet,
  private vararg val fileNames: String,
) : Detector(name) {

  protected open val depth: Int = 5

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .firstOrNull { it.name in fileNames }
      ?.also { ctx.log.d { "$name: '${it.name}' present" } }
      ?.let { block(sheet) }
      ?: sheet
}
