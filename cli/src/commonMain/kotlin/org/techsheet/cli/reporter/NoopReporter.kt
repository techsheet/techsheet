package org.techsheet.cli.reporter

import okio.FileSystem
import org.techsheet.cli.domain.TechSheetReport

/**
 * Reporter that reports nothing
 */
class NoopReporter(
  private val report: TechSheetReport,
  fs: FileSystem,
) : Reporter(fs) {

  override fun serialize(): String = ""
}
