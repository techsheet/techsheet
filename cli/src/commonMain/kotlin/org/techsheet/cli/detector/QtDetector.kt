package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class QtDetector : Detector(
  "Qt",
  Matcher.Filename("CMakeLists.txt"),
  Matcher.Extension(".pro"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { text ->
        val version = FIND_PACKAGE_QT.find(text)?.groupValues?.getOrNull(1)
          ?: QT_COMPONENT.find(text)?.groupValues?.getOrNull(1)
        when {
          version != null -> sheet.withFramework(FrameworkType.QT, version = version)
          QMAKE_QT_MODULE.containsMatchIn(text) -> sheet.withFramework(FrameworkType.QT)
          else -> sheet
        }
      }
      ?: sheet

  private companion object {
    val FIND_PACKAGE_QT = Regex("""find_package\s*\(\s*Qt(\d+)""")
    val QT_COMPONENT = Regex("""\bQt(\d+)::""")
    val QMAKE_QT_MODULE = Regex("""(?m)^\s*QT\s*[+*/]?=""")
  }
}
