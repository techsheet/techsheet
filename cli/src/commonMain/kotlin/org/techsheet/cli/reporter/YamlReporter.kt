package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import okio.FileSystem
import okio.Path
import org.techsheet.cli.domain.TechSheetReport

class YamlReporter(
  private val report: TechSheetReport,
  fs: FileSystem,
) : Reporter(fs) {

  private val yaml = Yaml(
    configuration = YamlConfiguration(
      encodeDefaults = false,
      strictMode = true,
      sequenceBlockIndent = 2,
    ),
  )

  override fun serialize(): String =
    yaml.encodeToString(TechSheetReport.serializer(), report) + "\n"

  companion object {
    const val DEFAULT_FILE_NAME = "techsheet.yml"
  }
}
