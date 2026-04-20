package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

class KotlinVersionDetector : Detector(
  "Kotlin (version)",
  Matcher.Filename("libs.versions.toml"),
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("settings.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("settings.gradle"),
  Matcher.Filename(".tool-versions"),
  Matcher.Filename("pom.xml"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { sheet.withLanguage(Language(LanguageType.KOTLIN, it)) }
      ?: sheet

  private fun extractVersion(filename: String, text: String): String? = when (filename) {
    "libs.versions.toml" -> text.lineSequence()
      .map(String::trim)
      .firstNotNullOfOrNull { CATALOG_KOTLIN_LINE.find(it)?.groupValues?.getOrNull(1) }
    "build.gradle.kts", "settings.gradle.kts", "build.gradle", "settings.gradle" ->
      GRADLE_KOTLIN_PLUGIN.find(text)?.groupValues?.getOrNull(1)
        ?: GRADLE_KOTLIN_ID.find(text)?.groupValues?.getOrNull(1)
    ".tool-versions" -> text.lineSequence()
      .firstNotNullOfOrNull { TOOL_VERSIONS_LINE.find(it)?.groupValues?.getOrNull(1) }
    "pom.xml" -> POM_KOTLIN_VERSION.find(text)?.groupValues?.getOrNull(1)
    else -> null
  }

  private companion object {
    val CATALOG_KOTLIN_LINE = Regex("""^kotlin\s*=\s*"([^"]+)"""")
    val GRADLE_KOTLIN_PLUGIN = Regex("""kotlin\s*\(\s*"[^"]+"\s*\)\s+version\s+"([^"]+)"""")
    val GRADLE_KOTLIN_ID = Regex("""id\s*\(\s*"org\.jetbrains\.kotlin[^"]*"\s*\)\s+version\s+"([^"]+)"""")
    val TOOL_VERSIONS_LINE = Regex("""^\s*kotlin\s+(\S+)""")
    val POM_KOTLIN_VERSION = Regex("""<kotlin\.version>\s*([^<\s]+)\s*</kotlin\.version>""")
  }
}
