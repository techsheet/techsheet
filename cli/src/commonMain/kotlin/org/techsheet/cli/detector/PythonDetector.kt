package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.ProgrammingLanguageType

class PythonDetector : AbstractSourceFileLanguageDetector(
  name = "Python",
  type = ProgrammingLanguageType.PYTHON,
  sourceExtension = PYTHON_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? =
    probePythonVersionFile(ctx)
      ?: probeToolVersions(ctx)
      ?: probePyproject(ctx)

  private fun probePythonVersionFile(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".python-version" }) { content ->
      PYTHON_VERSION_FILE.find(content)?.groupValues?.get(1)
    }

  private fun probeToolVersions(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".tool-versions" }) { content ->
      content.lineSequence().firstNotNullOfOrNull {
        TOOL_VERSIONS_LINE.find(it)?.groupValues?.get(1)
      }
    }

  private fun probePyproject(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == "pyproject.toml" }) { content ->
      REQUIRES_PYTHON.find(content)?.groupValues?.get(1)
    }

  companion object {
    private const val PYTHON_EXT = ".py"

    private val PYTHON_VERSION_FILE = Regex("""^\s*(\d+(?:\.\d+)*)""")
    private val TOOL_VERSIONS_LINE = Regex("""^\s*python\s+(\S+)""")
    private val REQUIRES_PYTHON =
      Regex("""requires-python\s*=\s*["'][^"']*?(\d+(?:\.\d+)+)""")
  }
}
