package org.techsheet.cli.reporter

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.TechSheetReport

class JsonReporter(
  path: Path,
  fs: FileSystem = FileSystem.SYSTEM,
) : AbstractFileReporter(path, fs) {

  @OptIn(ExperimentalSerializationApi::class)
  private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
    explicitNulls = false
  }

  override fun serialize(report: TechSheetReport): String =
    json.encodeToString(report) + "\n"
}
