package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.Tool
import org.techsheet.cli.domain.ToolType
import org.techsheet.cli.domain.TechSheet

class MavenDetector : Detector("Maven") {

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet {
    val markers = ctx.walk(MAX_DEPTH)
      .filter { it.name in ALL_MARKERS }
      .toSet()

    ctx.log.d("Checking maven markers: ${markers.joinToString(", ")}")

    val tool = detectType(markers)?.let { type ->
      Tool(type = type, version = detectVersion(ctx, markers))
    }
    return tool?.let(sheet::withTool) ?: sheet
  }

  private fun detectType(markers: Set<Path>): ToolType? {
    val names = markers.mapTo(HashSet()) { it.name }
    return if (names.any { it in ALL_MARKERS }) ToolType.MAVEN else null
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

    private const val POM_FILE = "pom.xml"
    private const val WRAPPER_SCRIPT = "mvnw"
    private const val WRAPPER_PROPERTIES = "maven-wrapper.properties"
    private const val DISTRIBUTION_URL_KEY = "distributionUrl="

    private val ALL_MARKERS: Set<String> = setOf(POM_FILE, WRAPPER_SCRIPT, WRAPPER_PROPERTIES)

    private val DISTRIBUTION_URL_VERSION = Regex("""apache-maven-(.+?)-bin\.(zip|tar\.gz)""")
  }
}
