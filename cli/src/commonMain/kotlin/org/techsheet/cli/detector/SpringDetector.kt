package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class SpringDetector : Detector("Spring") {

  // Monorepos can hold multiple build modules under apps/*, services/*, etc.
  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name in BUILD_FILES }
      .mapNotNull(ctx::readFileContents)
      .joinToString("\n")
      .takeIf(String::isNotEmpty)
      ?.let { content -> markers(bootVersion(content)).fold(sheet, appendIfPresent(content)) }
      ?: sheet

  private fun bootVersion(content: String): String? =
    BOOT_VERSION_GRADLE.find(content)?.groupValues?.get(1)
      ?: BOOT_VERSION_MAVEN.find(content)?.groupValues?.get(1)

  private fun appendIfPresent(content: String): (TechSheet, Marker) -> TechSheet =
    { acc, (type, regex, version) ->
      if (regex.containsMatchIn(content)) acc.withFramework(type, version) else acc
    }

  private fun markers(bootVersion: String?): List<Marker> = listOf(
    Marker(FrameworkType.SPRING_BOOT, SPRING_BOOT, bootVersion),
    Marker(FrameworkType.SPRING_MVC, SPRING_MVC, null),
    Marker(FrameworkType.SPRING_WEBFLUX, SPRING_WEBFLUX, null),
    Marker(FrameworkType.SPRING_SECURITY, SPRING_SECURITY, null),
    Marker(FrameworkType.SPRING_DATA, SPRING_DATA, null),
  )

  private data class Marker(val type: FrameworkType, val regex: Regex, val version: String?)

  companion object {
    private val BUILD_FILES = setOf("build.gradle.kts", "build.gradle", "pom.xml")

    // Any Spring Boot starter / plugin / BOM reference implies Boot itself.
    private val SPRING_BOOT = Regex("""spring-boot""")

    // MVC: Boot 4 uses `-starter-webmvc`; Boot <=3 uses `-starter-web` (but NOT -webflux).
    // Plain Spring projects use `spring-webmvc`.
    private val SPRING_MVC =
      Regex("""spring-boot-starter-webmvc|spring-boot-starter-web(?!flux|mvc|-)|spring-webmvc""")

    private val SPRING_WEBFLUX = Regex("""spring-(?:boot-starter-)?webflux""")
    private val SPRING_SECURITY = Regex("""spring-(?:boot-starter-)?security""")
    private val SPRING_DATA = Regex("""spring-(?:boot-starter-)?data""")

    private val BOOT_VERSION_GRADLE =
      Regex("""org\.springframework\.boot["']\s*\)?\s*version\s+["']([^"']+)["']""")
    private val BOOT_VERSION_MAVEN =
      Regex("""<artifactId>spring-boot-starter-parent</artifactId>\s*<version>([^<]+)</version>""")
  }
}
