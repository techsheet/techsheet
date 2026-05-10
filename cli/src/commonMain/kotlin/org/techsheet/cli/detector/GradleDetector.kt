package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class GradleDetector : Detector(
  "Gradle",
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("settings.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("settings.gradle"),
  Matcher.Filename("gradlew"),
  Matcher.Filename(WRAPPER_PROPERTIES),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(
      type = ToolType.GRADLE,
      version = versionFor(path.name, content),
      flavor = flavorFor(path.name),
    )

  private fun flavorFor(name: String): String? = when (name) {
    in KOTLIN_DSL_FILES -> "Kotlin DSL"
    in GROOVY_DSL_FILES -> "Groovy DSL"
    else -> null
  }

  private fun versionFor(name: String, content: Lazy<String?>): String? =
    name.takeIf { it == WRAPPER_PROPERTIES }?.let { versionFromWrapper(content.value) }

  private fun versionFromWrapper(text: String?): String? = text
    ?.lineSequence()
    ?.map(String::trim)
    ?.firstOrNull { it.startsWith(DISTRIBUTION_URL_KEY) }
    ?.substringAfter(DISTRIBUTION_URL_KEY)
    ?.let(DISTRIBUTION_URL_VERSION::find)
    ?.groupValues
    ?.getOrNull(1)

  private companion object {
    const val WRAPPER_PROPERTIES = "gradle-wrapper.properties"
    const val DISTRIBUTION_URL_KEY = "distributionUrl="
    val KOTLIN_DSL_FILES = setOf("build.gradle.kts", "settings.gradle.kts")
    val GROOVY_DSL_FILES = setOf("build.gradle", "settings.gradle")
    val DISTRIBUTION_URL_VERSION = Regex("""gradle-(.+?)-(bin|all)\.zip""")
  }
}
