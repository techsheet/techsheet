package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class JUnitDetector : Detector(
  "JUnit",
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("pom.xml"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { text ->
        when {
          JUNIT_5.containsMatchIn(text) -> sheet.withFramework(FrameworkType.JUNIT, version = "5")
          JUNIT_4.containsMatchIn(text) -> sheet.withFramework(FrameworkType.JUNIT, version = "4")
          else -> sheet
        }
      }
      ?: sheet

  private companion object {
    // JUnit 5: Jupiter / Platform artifacts, the Gradle task toggle, and Kotlin's JUnit 5 bridge.
    val JUNIT_5 =
      Regex("""junit-jupiter|junit-platform|useJUnitPlatform|kotlin-test-junit5""")

    // JUnit 4: classic junit:junit coordinates, the vintage engine, and Kotlin's JUnit 4 bridge
    // (kotlin-test-junit, but NOT kotlin-test-junit5 which is caught above).
    val JUNIT_4 = Regex(
      """junit-vintage-engine""" +
        """|["']junit["']\s*:\s*["']junit["']""" +
        """|<groupId>junit</groupId>\s*<artifactId>junit</artifactId>""" +
        """|kotlin-test-junit(?!5)"""
    )
  }
}
