package org.techsheet.cli.detector

import org.techsheet.cli.domain.AnalyzerContext
import org.techsheet.cli.domain.ProgrammingLanguageType

class KotlinDetector : AbstractJvmLanguageDetector(
  name = "Kotlin",
  type = ProgrammingLanguageType.KOTLIN,
  sourceExtension = KOTLIN_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? =
    probeVersionCatalog(ctx)
      ?: probeGradleBuild(ctx)
      ?: probeToolVersions(ctx)
      ?: probePom(ctx)

  private fun probeVersionCatalog(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == "libs.versions.toml" }) { content ->
      content.lineSequence()
        .map(String::trim)
        .firstNotNullOfOrNull { CATALOG_KOTLIN_LINE.find(it)?.groupValues?.get(1) }
    }

  private fun probeGradleBuild(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it in GRADLE_BUILD_FILES }) { content ->
      GRADLE_KOTLIN_PLUGIN.find(content)?.groupValues?.get(1)
        ?: GRADLE_KOTLIN_ID.find(content)?.groupValues?.get(1)
    }

  private fun probeToolVersions(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".tool-versions" }) { content ->
      content.lineSequence().firstNotNullOfOrNull {
        TOOL_VERSIONS_LINE.find(it)?.groupValues?.get(1)
      }
    }

  private fun probePom(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == "pom.xml" }) {
      POM_KOTLIN_VERSION.find(it)?.groupValues?.get(1)
    }

  companion object {
    private const val KOTLIN_EXT = ".kt"

    private val CATALOG_KOTLIN_LINE =
      Regex("""^kotlin\s*=\s*"([^"]+)"""")
    private val GRADLE_KOTLIN_PLUGIN =
      Regex("""kotlin\s*\(\s*"[^"]+"\s*\)\s+version\s+"([^"]+)"""")
    private val GRADLE_KOTLIN_ID =
      Regex("""id\s*\(\s*"org\.jetbrains\.kotlin[^"]*"\s*\)\s+version\s+"([^"]+)"""")
    private val TOOL_VERSIONS_LINE =
      Regex("""^\s*kotlin\s+(\S+)""")
    private val POM_KOTLIN_VERSION =
      Regex("""<kotlin\.version>\s*([^<\s]+)\s*</kotlin\.version>""")

    private val GRADLE_BUILD_FILES = setOf(
      "build.gradle.kts", "settings.gradle.kts",
      "build.gradle", "settings.gradle",
    )
  }
}
