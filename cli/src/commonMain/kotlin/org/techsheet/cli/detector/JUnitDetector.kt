package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class JUnitDetector : Detector("JUnit") {

  // Monorepos can hold multiple build modules under apps/*, services/*, etc.
  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name in BUILD_FILES }
      .mapNotNull(ctx::readFileContents)
      .joinToString("\n")
      .takeIf(String::isNotEmpty)
      ?.let { content ->
        when {
          JUNIT_5.containsMatchIn(content) -> sheet.withTechnology(TechnologyType.JUNIT, version = "5")
          JUNIT_4.containsMatchIn(content) -> sheet.withTechnology(TechnologyType.JUNIT, version = "4")
          else -> sheet
        }
      }
      ?: sheet

  companion object {
    private val BUILD_FILES = setOf("build.gradle.kts", "build.gradle", "pom.xml")

    // JUnit 5: Jupiter / Platform artifacts, the Gradle task toggle, and Kotlin's JUnit 5 bridge.
    private val JUNIT_5 =
      Regex("""junit-jupiter|junit-platform|useJUnitPlatform|kotlin-test-junit5""")

    // JUnit 4: classic junit:junit coordinates, the vintage engine, and Kotlin's JUnit 4 bridge
    // (kotlin-test-junit, but NOT kotlin-test-junit5 which is caught above).
    private val JUNIT_4 = Regex(
      """junit-vintage-engine""" +
        """|["']junit["']\s*:\s*["']junit["']""" +
        """|<groupId>junit</groupId>\s*<artifactId>junit</artifactId>""" +
        """|kotlin-test-junit(?!5)"""
    )
  }
}
