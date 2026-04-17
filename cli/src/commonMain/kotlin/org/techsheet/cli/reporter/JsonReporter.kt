package org.techsheet.cli.reporter

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okio.Path
import org.techsheet.cli.domain.TechSheetReport

class JsonReporter(path: Path) : AbstractFileReporter(path) {

  @OptIn(ExperimentalSerializationApi::class)
  private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
    explicitNulls = false
  }

  override fun serialize(report: TechSheetReport): String =
    json.encodeToString(report) + "\n"
}
