package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class QtDetector : Detector("Qt") {

  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name == "CMakeLists.txt" || it.name.endsWith(".pro") }
      .mapNotNull(ctx::readFileContents)
      .joinToString("\n")
      .takeIf(String::isNotEmpty)
      ?.let { content ->
        val version = FIND_PACKAGE_QT.find(content)?.groupValues?.get(1)
          ?: QT_COMPONENT.find(content)?.groupValues?.get(1)
        when {
          version != null -> sheet.withTechnology(TechnologyType.QT, version = version)
          QMAKE_QT_MODULE.containsMatchIn(content) -> sheet.withTechnology(TechnologyType.QT)
          else -> sheet
        }
      }
      ?: sheet

  companion object {
    private val FIND_PACKAGE_QT = Regex("""find_package\s*\(\s*Qt(\d+)""")
    private val QT_COMPONENT = Regex("""\bQt(\d+)::""")
    private val QMAKE_QT_MODULE = Regex("""(?m)^\s*QT\s*[+*/]?=""")
  }
}
