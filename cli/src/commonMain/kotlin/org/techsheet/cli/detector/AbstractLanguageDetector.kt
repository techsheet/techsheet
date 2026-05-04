package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

/**
 * Detects a language by matching source file extensions
 *
 * No content inspection is performed, as normally, compilers / interpreters operate on file name suffixes.
 *
 * Override [skipFiles] with filenames that should be excluded to avoid false positives on well-known tooling files
 * sharing the same extension (e.g. `gradlew.bat`).
 */
abstract class AbstractLanguageDetector(
  name: String,
  private val type: LanguageType,
  vararg sourceExtensions: String,
) : Detector(
  name,
  *sourceExtensions.map<String, Matcher> { Matcher.Extension(it) }.toTypedArray(),
) {

  protected open val skipFiles: List<String> = emptyList()

  override fun skipIf(path: Path, sheet: TechSheet): Boolean =
    path.name in skipFiles || sheet.hasLanguage(type)

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    sheet.withLanguage(Language(type, version = null))
}
