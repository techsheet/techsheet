package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.ProgrammingLanguageType

class ScalaDetector : AbstractJvmLanguageDetector(
  name = "Scala",
  type = ProgrammingLanguageType.Scala,
  sourceExtension = SCALA_EXT,
) {

  override fun detectVersion(ctx: AnalyzerContext): String? =
    probeSbt(ctx)
      ?: probeToolVersions(ctx)
      ?: probePom(ctx)

  private fun probeSbt(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it in SBT_FILES }) {
      SBT_SCALA_VERSION.find(it)?.groupValues?.get(1)
    }

  private fun probeToolVersions(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == ".tool-versions" }) { content ->
      content.lineSequence().firstNotNullOfOrNull {
        TOOL_VERSIONS_LINE.find(it)?.groupValues?.get(1)
      }
    }

  private fun probePom(ctx: AnalyzerContext) =
    firstMatchIn(ctx, { it == "pom.xml" }) { content ->
      POM_SCALA_VERSION.find(content)?.groupValues?.get(1)
        ?: POM_SCALA_PLUGIN_VERSION.find(content)?.groupValues?.get(1)
    }

  companion object {
    private const val SCALA_EXT = ".scala"

    private val SBT_FILES = setOf("build.sbt", "Build.scala")

    private val SBT_SCALA_VERSION =
      Regex("""scalaVersion\s*:=\s*"([^"]+)"""")
    private val TOOL_VERSIONS_LINE =
      Regex("""^\s*scala\s+(\S+)""")
    private val POM_SCALA_VERSION =
      Regex("""<scala\.version>\s*([^<\s]+)\s*</scala\.version>""")
    private val POM_SCALA_PLUGIN_VERSION =
      Regex("""<scalaVersion>\s*([^<\s]+)\s*</scalaVersion>""")
  }
}
