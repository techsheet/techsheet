package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class SpringDetector : Detector(
  "Spring",
  Matcher.Filename("build.gradle.kts"),
  Matcher.Filename("build.gradle"),
  Matcher.Filename("pom.xml"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { text ->
        MARKERS
          .filter { it.presence.containsMatchIn(text) }
          .fold(sheet) { acc, marker ->
            acc.withFramework(
              marker.type,
              marker.type.takeIf { it == FrameworkType.SPRING_BOOT }?.let { bootVersion(text) },
            )
          }
      }
      ?: sheet

  private fun bootVersion(text: String): String? =
    BOOT_VERSION_GRADLE.find(text)?.groupValues?.getOrNull(1)
      ?: BOOT_VERSION_MAVEN.find(text)?.groupValues?.getOrNull(1)

  private data class Marker(val type: FrameworkType, val presence: Regex)

  private companion object {
    val SPRING_BOOT = Regex("""spring-boot""")
    val SPRING_MVC =
      Regex("""spring-boot-starter-webmvc|spring-boot-starter-web(?!flux|mvc|-)|spring-webmvc""")
    val SPRING_WEBFLUX = Regex("""spring-(?:boot-starter-)?webflux""")
    val SPRING_SECURITY = Regex("""spring-(?:boot-starter-)?security""")
    val SPRING_DATA = Regex("""spring-(?:boot-starter-)?data""")

    val MARKERS = listOf(
      Marker(FrameworkType.SPRING_BOOT, SPRING_BOOT),
      Marker(FrameworkType.SPRING_MVC, SPRING_MVC),
      Marker(FrameworkType.SPRING_WEBFLUX, SPRING_WEBFLUX),
      Marker(FrameworkType.SPRING_SECURITY, SPRING_SECURITY),
      Marker(FrameworkType.SPRING_DATA, SPRING_DATA),
    )

    val BOOT_VERSION_GRADLE =
      Regex("""org\.springframework\.boot["']\s*\)?\s*version\s+["']([^"']+)["']""")
    val BOOT_VERSION_MAVEN =
      Regex("""<artifactId>spring-boot-starter-parent</artifactId>\s*<version>([^<]+)</version>""")
  }
}
