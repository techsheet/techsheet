package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.Language
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet

class JavaVersionDetector : Detector(
  "Java (version)",
  Matcher.Filename("pom.xml"),
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("settings.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("settings.gradle"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { sheet.withLanguage(Language(LanguageType.JAVA, it)) }
      ?: sheet

  private fun extractVersion(filename: String, text: String): String? = when (filename) {
    "pom.xml" -> POM_SOURCE.find(text)?.groupValues?.getOrNull(1)
    "build.gradle.kts", "settings.gradle.kts", "build.gradle", "settings.gradle" ->
      GRADLE_COMPATIBILITY.find(text)?.groupValues?.getOrNull(1)
    else -> null
  }

  private companion object {
    val POM_SOURCE = Regex(
      """<(?:maven\.compiler\.(?:source|target)|java\.version)>\s*(\d+(?:\.\d+)*)\s*</""",
    )
    val GRADLE_COMPATIBILITY = Regex(
      """(?:sourceCompatibility|targetCompatibility)\s*=?\s*(?:JavaVersion\.VERSION_)?["']?(\d+(?:\.\d+)*)["']?""",
    )
  }
}
