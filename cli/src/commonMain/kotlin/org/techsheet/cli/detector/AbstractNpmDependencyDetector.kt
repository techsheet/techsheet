package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult

/**
 * Detects a technology by its presence as a named package in `package.json`
 *
 * Version range prefixes (`^`, `~`, `>=`, `=`) are stripped; a missing version is passed as `null`.
 *
 * TODO: This should be generalized to also consult other JS/TS ecosystem build-tools, and thjen renamed to
 *       AbstractJsDependencyDetector. Additionally, there should be specific implementations for frameworks, i.e.
 *       AbstractJsFrameworkDetector.
 */
abstract class AbstractNpmDependencyDetector(
  name: String,
  packageName: String,
  private val apply: (DetectionResult, String?) -> DetectionResult,
) : Detector(name, Matcher.Filename("package.json")) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    content.value
      ?.let(versionRegex::find)
      ?.groupValues
      ?.getOrNull(1)
      ?.trimStart('^', '~', '>', '=', ' ')
      ?.ifEmpty { null }
      ?.let { apply(result, it) }
      ?: result

  private val versionRegex = Regex(""""${Regex.escape(packageName)}"\s*:\s*"([^"]+)"""")
}
