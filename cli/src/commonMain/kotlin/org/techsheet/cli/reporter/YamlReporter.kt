package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import okio.Path
import org.techsheet.cli.domain.TechSheetReport

class YamlReporter(path: Path) : AbstractFileReporter(path) {

  private val yaml = Yaml(
    configuration = YamlConfiguration(
      encodeDefaults = false,
      strictMode = false,
      sequenceBlockIndent = 2,
    ),
  )

  override fun serialize(report: TechSheetReport): String =
    yaml.encodeToString(TechSheetReport.serializer(), report) + "\n"
}
