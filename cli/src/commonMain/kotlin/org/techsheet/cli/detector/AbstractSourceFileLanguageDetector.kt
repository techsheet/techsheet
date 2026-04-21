package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

abstract class AbstractSourceFileLanguageDetector(
  name: String,
  private val type: LanguageType,
  vararg sourceExtensions: String,
) : Detector(
  name,
  *sourceExtensions.map<String, Matcher> { Matcher.Extension(it) }.toTypedArray(),
) {

  override fun skipIf(path: Path, sheet: TechSheet): Boolean = sheet.hasLanguage(type)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withLanguage(Language(type, version = null))
}
