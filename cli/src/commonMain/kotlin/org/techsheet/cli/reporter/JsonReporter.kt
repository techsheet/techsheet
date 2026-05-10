package org.techsheet.cli.reporter

import kotlinx.serialization.json.Json
import okio.FileSystem
import org.techsheet.schema.TechSheet

class JsonReporter(
    private val techSheet: TechSheet,
    fs: FileSystem,
) : Reporter(fs) {

  private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
    explicitNulls = false
  }

  override fun serialize(): String = json.encodeToString(techSheet) + "\n"
}
