package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.ProgrammingLanguageType

class JavaDetector : AbstractSourceFileLanguageDetector(
  name = "Java",
  type = ProgrammingLanguageType.JAVA,
  sourceExtension = JAVA_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? =
    probeJavaVersionFile(ctx)
      ?: probeToolVersions(ctx)
      ?: probePom(ctx)
      ?: probeGradle(ctx)

  private fun probeJavaVersionFile(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".java-version" }) {
      JAVA_VERSION_FILE.find(it)?.groupValues?.get(1)
    }

  private fun probeToolVersions(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".tool-versions" }) { content ->
      content.lineSequence().firstNotNullOfOrNull {
        TOOL_VERSIONS_LINE.find(it)?.groupValues?.get(1)
      }
    }

  private fun probePom(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == "pom.xml" }) {
      POM_PROPERTY.find(it)?.groupValues?.get(1)
    }

  private fun probeGradle(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it in GRADLE_BUILD_FILES }) { content ->
      GRADLE_TOOLCHAIN.find(content)?.groupValues?.get(1)
        ?: GRADLE_COMPATIBILITY.find(content)?.groupValues?.get(1)
    }

  companion object {
    private const val JAVA_EXT = ".java"

    private val JAVA_VERSION_FILE = Regex("""^\s*(\d+(?:\.\d+)*)\s*$""")
    private val TOOL_VERSIONS_LINE = Regex("""^\s*java\s+(?:\S+-)?(\d+(?:\.\d+)*)""")
    private val POM_PROPERTY = Regex(
      """<(?:maven\.compiler\.(?:source|target|release)|java\.version|release)>\s*(\d+(?:\.\d+)*)\s*</""",
    )
    private val GRADLE_COMPATIBILITY = Regex(
      """(?:sourceCompatibility|targetCompatibility)\s*=?\s*(?:JavaVersion\.VERSION_)?["']?(\d+(?:\.\d+)*)["']?""",
    )
    private val GRADLE_TOOLCHAIN = Regex("""(?:jvmToolchain|JavaLanguageVersion\.of)\s*\(\s*(\d+)""")

    private val GRADLE_BUILD_FILES = setOf(
      "build.gradle.kts", "settings.gradle.kts",
      "build.gradle", "settings.gradle",
    )
  }
}
