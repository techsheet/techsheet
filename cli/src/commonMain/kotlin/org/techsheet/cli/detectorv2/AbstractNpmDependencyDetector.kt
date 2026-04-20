package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet

abstract class AbstractNpmDependencyDetector(
  name: String,
  packageName: String,
  private val apply: (TechSheet, String?) -> TechSheet,
) : Detector(name, Matcher.Filename("package.json")) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let(versionRegex::find)
      ?.groupValues
      ?.getOrNull(1)
      ?.trimStart('^', '~', '>', '=', ' ')
      ?.ifEmpty { null }
      ?.let { apply(sheet, it) }
      ?: sheet

  private val versionRegex = Regex(""""${Regex.escape(packageName)}"\s*:\s*"([^"]+)"""")
}
