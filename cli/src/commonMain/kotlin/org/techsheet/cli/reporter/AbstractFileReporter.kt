package org.techsheet.cli.reporter

import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechSheetReport

abstract class AbstractFileReporter(
  private val path: Path,
  private val fs: FileSystem = FileSystem.SYSTEM,
) : Reporter {

  override fun report(sheet: TechSheet) {
    val report = TechSheetReport.of(sheet)
    val content = serialize(report)
    path.parent?.let { fs.createDirectories(it) }
    fs.write(path) { writeUtf8(content) }
  }

  protected abstract fun serialize(report: TechSheetReport): String
}
