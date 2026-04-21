package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.techsheet.cli.domain.TechSheetReport

class YamlReporter(
  path: Path,
  fs: FileSystem = FileSystem.SYSTEM,
) : AbstractFileReporter(path, fs) {

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
