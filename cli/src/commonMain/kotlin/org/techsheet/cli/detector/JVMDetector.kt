package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType

class JVMDetector : Detector(
  "JVM",
  Matcher.Filename(".java-version"),
  Matcher.Filename(".tool-versions"),
  Matcher.Filename("pom.xml"),
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("settings.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("settings.gradle"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { sheet.withTool(ToolType.JVM, it) }
      ?: sheet

  private fun extractVersion(filename: String, text: String): String? = when (filename) {
    ".java-version" -> JAVA_VERSION_FILE.find(text)?.groupValues?.getOrNull(1)
    ".tool-versions" -> text.lineSequence()
      .firstNotNullOfOrNull { TOOL_VERSIONS_LINE.find(it)?.groupValues?.getOrNull(1) }
    "pom.xml" -> POM_RUNTIME.find(text)?.groupValues?.getOrNull(1)
    "build.gradle.kts", "settings.gradle.kts", "build.gradle", "settings.gradle" ->
      GRADLE_TOOLCHAIN.find(text)?.groupValues?.getOrNull(1)
    else -> null
  }

  private companion object {
    val JAVA_VERSION_FILE = Regex("""^\s*(\d+(?:\.\d+)*)\s*$""")
    val TOOL_VERSIONS_LINE = Regex("""^\s*java\s+(?:\S+-)?(\d+(?:\.\d+)*)""")
    val POM_RUNTIME = Regex(
      """<(?:maven\.compiler\.release|java\.version|release)>\s*(\d+(?:\.\d+)*)\s*</""",
    )
    val GRADLE_TOOLCHAIN = Regex("""(?:jvmToolchain|JavaLanguageVersion\.of)\s*\(\s*(\d+)""")
  }
}
