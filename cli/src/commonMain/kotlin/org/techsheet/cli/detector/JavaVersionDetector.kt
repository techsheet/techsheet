package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectedLanguage
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.DetectionResult

class JavaVersionDetector : Detector(
  "Java (version)",
  Matcher.Filename("pom.xml"),
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("settings.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("settings.gradle"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { result.withLanguage(DetectedLanguage(LanguageType.JAVA, it)) }
      ?: result

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
