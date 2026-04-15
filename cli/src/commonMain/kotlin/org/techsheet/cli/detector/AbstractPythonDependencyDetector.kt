package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

/**
 * Base for Python framework/library detectors. Scans common Python dependency
 * manifests (requirements*.txt, pyproject.toml, Pipfile, setup.py, setup.cfg)
 * for a given package name and, where possible, extracts its version.
 */
abstract class AbstractPythonDependencyDetector(
  name: String,
  private val technology: TechnologyType,
  private val packageName: String,
) : Detector(name) {

  protected open val depth: Int = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name in DEPENDENCY_FILES }
      .mapNotNull(ctx::readFileContents)
      .joinToString("\n")
      .takeIf(presenceRegex::containsMatchIn)
      ?.also { ctx.log.d { "$name: '$packageName' present in Python dependencies" } }
      ?.let { content -> sheet.withTechnology(technology, version = versionRegex.find(content)?.groupValues?.get(1)) }
      ?: sheet

  private val presenceRegex = Regex("""\b${Regex.escape(packageName)}\b""", RegexOption.IGNORE_CASE)

  // On the same line as the package name, capture the first version-looking token.
  // Works for `django==4.2.7`, `django>=4.2`, `django = "^4.2"`, `"django~=4.2"` etc.
  private val versionRegex = Regex(
    """(?i)\b${Regex.escape(packageName)}\b[^\n]*?(\d+(?:\.[0-9A-Za-z.\-]+)*)""",
  )

  companion object {
    private val DEPENDENCY_FILES = setOf(
      "requirements.txt",
      "requirements-dev.txt",
      "pyproject.toml",
      "Pipfile",
      "setup.py",
      "setup.cfg",
    )
  }
}
