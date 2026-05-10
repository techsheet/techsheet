package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import okio.FileSystem
import org.techsheet.schema.TechSheet

class YamlReporter(
  private val techSheet: TechSheet,
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
    yaml.encodeToString(TechSheet.serializer(), techSheet) + "\n"

  companion object {
    const val DEFAULT_FILE_NAME = "techsheet.yml"
  }
}
