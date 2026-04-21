package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

class PythonVersionDetector : Detector(
  "Python (version)",
  Matcher.Filename(".python-version"),
  Matcher.Filename(".tool-versions"),
  Matcher.Filename("pyproject.toml"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { sheet.withLanguage(Language(LanguageType.PYTHON, it)) }
      ?: sheet

  private fun extractVersion(filename: String, text: String): String? = when (filename) {
    ".python-version" -> PYTHON_VERSION_FILE.find(text)?.groupValues?.getOrNull(1)
    ".tool-versions" -> text.lineSequence()
      .firstNotNullOfOrNull { TOOL_VERSIONS_LINE.find(it)?.groupValues?.getOrNull(1) }
    "pyproject.toml" -> REQUIRES_PYTHON.find(text)?.groupValues?.getOrNull(1)
    else -> null
  }

  private companion object {
    val PYTHON_VERSION_FILE = Regex("""^\s*(\d+(?:\.\d+)*)""")
    val TOOL_VERSIONS_LINE = Regex("""^\s*python\s+(\S+)""")
    val REQUIRES_PYTHON = Regex("""requires-python\s*=\s*["'][^"']*?(\d+(?:\.\d+)+)""")
  }
}
