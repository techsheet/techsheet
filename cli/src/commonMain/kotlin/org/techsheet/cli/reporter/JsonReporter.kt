package org.techsheet.cli.reporter

import kotlinx.serialization.json.Json
import okio.FileSystem
import okio.Path
import org.techsheet.cli.domain.TechSheetReport

class JsonReporter(
  private val report: TechSheetReport,
  fs: FileSystem,
) : Reporter(fs) {

  private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
    explicitNulls = false
  }

  override fun serialize(): String = json.encodeToString(report) + "\n"
}
