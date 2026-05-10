package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.DetectionResult

/**
 * Base for Python framework/library detectors
 *
 * Inspects common Python dependency manifests (requirements*.txt, pyproject.toml, Pipfile, setup.py, setup.cfg)
 * for a given package name and, where possible, extracts its version.
 */
abstract class AbstractPythonFrameworkDetector(
  name: String,
  private val framework: FrameworkType,
  packageName: String,
) : Detector(
  name,
  Matcher.Filename("requirements.txt"),
  Matcher.Filename("requirements-dev.txt"),
  Matcher.Filename("pyproject.toml"),
  Matcher.Filename("Pipfile"),
  Matcher.Filename("setup.py"),
  Matcher.Filename("setup.cfg"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    content.value
      ?.takeIf(presenceRegex::containsMatchIn)
      ?.let { result.withFramework(framework, versionRegex.find(it)?.groupValues?.getOrNull(1)) }
      ?: result

  // `\b…\b(?!-)` so `django` does not match `django-crispy-forms`, `django-rest-framework`,
  // etc. — hyphenated ecosystem packages form a word boundary with `-` but are not the package
  // we're looking for. The `_` case is already excluded by `\b` since `_` is a word char.
  private val presenceRegex = Regex(
    """\b${Regex.escape(packageName)}\b(?!-)""",
    RegexOption.IGNORE_CASE,
  )

  // On the same line as the package name, capture the first version-looking token.
  // Works for `django==4.2.7`, `django>=4.2`, `django = "^4.2"`, `"django~=4.2"` etc.
  private val versionRegex = Regex(
    """(?i)\b${Regex.escape(packageName)}\b(?!-)[^\n]*?(\d+(?:\.[0-9A-Za-z.\-]+)*)""",
  )
}
