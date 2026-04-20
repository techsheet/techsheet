package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

abstract class AbstractSourceFileLanguageDetector(
  name: String,
  private val type: LanguageType,
  sourceExtension: String,
) : Detector(name, Matcher.Extension(sourceExtension)) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasLanguage(type)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withLanguage(Language(type, version = null))
}
