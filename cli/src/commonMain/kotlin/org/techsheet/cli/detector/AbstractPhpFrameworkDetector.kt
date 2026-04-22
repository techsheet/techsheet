package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet

/**
 * Base for PHP framework/library detectors. Inspects Composer manifests
 * (`composer.json`, `composer.lock`) for one or more package coordinates and
 * extracts a version where possible.
 *
 * Regex over JSON parsing is a deliberate choice — consistent with the other
 * dependency detectors and tolerant of slightly malformed manifests that a
 * strict parser would reject.
 */
abstract class AbstractPhpFrameworkDetector(
  name: String,
  private val framework: FrameworkType,
  private val packageNames: List<String>,
) : Detector(
  name,
  Matcher.Filename("composer.json"),
  Matcher.Filename("composer.lock"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value?.let { text ->
      packageNames.fold(sheet) { acc, pkg ->
        when (path.name) {
          "composer.lock" -> lockVersionRegex(pkg).find(text)
          else -> manifestVersionRegex(pkg).find(text)
        }
          ?.groupValues?.getOrNull(1)
          ?.trimStart('^', '~', '>', '=', ' ', 'v')
          ?.ifEmpty { null }
          ?.let { acc.withFramework(framework, it) }
          ?: acc
      }
    } ?: sheet

  private fun manifestVersionRegex(pkg: String): Regex =
    Regex(""""${Regex.escape(pkg)}"\s*:\s*"([^"]+)"""")

  // composer.lock writes packages with `name` immediately followed by `version` in the
  // same object, so a positional pattern reliably correlates the two without balanced-brace matching.
  private fun lockVersionRegex(pkg: String): Regex =
    Regex(""""name"\s*:\s*"${Regex.escape(pkg)}"\s*,\s*"version"\s*:\s*"([^"]+)"""")
}
