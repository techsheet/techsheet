package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.BuildTool
import org.techsheet.cli.domain.BuildToolType
import org.techsheet.cli.domain.TechSheet

class GradleDetector : Detector("Gradle") {

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet {
    val markers = ctx.walk(MAX_DEPTH)
      .filter { it.name in ALL_MARKERS }
      .toSet()

    ctx.log.d("Checking gradle markers: ${markers.joinToString(", ")}")

    val tool = detectType(markers)?.let { type ->
      BuildTool(type = type, version = detectVersion(ctx, markers))
    }
    return tool?.let(sheet::withBuildTool) ?: sheet
  }

  private fun detectType(markers: Set<Path>): BuildToolType? {
    val names = markers.mapTo(HashSet()) { it.name }
    return when {
      names.any { it in KOTLIN_DSL_FILES } -> BuildToolType.GRADLE_KOTLIN
      names.any { it in GROOVY_DSL_FILES } -> BuildToolType.GRADLE_GROOVY
      names.any { it in WRAPPER_FILES } -> BuildToolType.GRADLE
      else -> null
    }
  }

  private fun detectVersion(ctx: AnalyzerContext, markers: Set<Path>): String? = markers
    .firstOrNull { it.name == WRAPPER_PROPERTIES }
    ?.let(ctx::readFileContents)
    ?.lineSequence()
    ?.map(String::trim)
    ?.firstOrNull { it.startsWith(DISTRIBUTION_URL_KEY) }
    ?.substringAfter(DISTRIBUTION_URL_KEY)
    ?.let(DISTRIBUTION_URL_VERSION::find)
    ?.groupValues
    ?.get(1)

  companion object {
    private const val MAX_DEPTH = 3

    private const val WRAPPER_PROPERTIES = "gradle-wrapper.properties"
    private const val DISTRIBUTION_URL_KEY = "distributionUrl="

    private val KOTLIN_DSL_FILES = setOf("build.gradle.kts", "settings.gradle.kts")
    private val GROOVY_DSL_FILES = setOf("build.gradle", "settings.gradle")
    private val WRAPPER_FILES = setOf("gradlew", WRAPPER_PROPERTIES)

    private val ALL_MARKERS: Set<String> = KOTLIN_DSL_FILES + GROOVY_DSL_FILES + WRAPPER_FILES

    private val DISTRIBUTION_URL_VERSION = Regex("""gradle-(.+?)-(bin|all)\.zip""")
  }
}
