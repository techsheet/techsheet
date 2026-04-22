package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet

/**
 * Base for framework detectors keyed off a single file marker.
 *
 * `contentMatch` (when set) serves two purposes in one regex: it validates the file
 * is genuinely a marker for this framework AND, if it has a capture group, extracts
 * the version. When `contentMatch` is null, the marker filename alone is treated as
 * sufficient and no version is reported.
 */
abstract class AbstractFileMarkerFrameworkDetector(
  name: String,
  private val framework: FrameworkType,
  marker: Matcher,
  private val contentMatch: Regex? = null,
) : Detector(name, marker) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    if (contentMatch == null) {
      sheet.withFramework(framework)
    } else {
      content.value
        ?.let(contentMatch::find)
        ?.let { sheet.withFramework(framework, it.groupValues.getOrNull(1)?.ifEmpty { null }) }
        ?: sheet
    }
}
