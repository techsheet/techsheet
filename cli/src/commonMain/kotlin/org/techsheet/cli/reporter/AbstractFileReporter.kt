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
    report(TechSheetReport.of(sheet))
  }

  fun report(report: TechSheetReport) {
    val content = serialize(report)

    path.parent?.also {
      fs.createDirectories(it)
    }

    fs.write(path) {
      writeUtf8(content)
    }
  }

  protected abstract fun serialize(report: TechSheetReport): String
}
