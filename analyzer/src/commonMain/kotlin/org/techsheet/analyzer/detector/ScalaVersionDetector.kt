package org.techsheet.analyzer.detector

import okio.Path
import org.techsheet.analyzer.domain.DetectedLanguage
import org.techsheet.analyzer.domain.DetectionResult
import org.techsheet.analyzer.domain.LanguageType
import org.techsheet.analyzer.domain.Matcher

class ScalaVersionDetector : Detector(
  "Scala (version)",
  Matcher.Filename("build.sbt"),
  Matcher.Filename("Build.scala"),
  Matcher.Filename(".tool-versions"),
  Matcher.Filename("pom.xml"),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    content.value
      ?.let { extractVersion(path.name, it) }
      ?.let { result.withLanguage(DetectedLanguage(LanguageType.SCALA, it)) }
      ?: result

  private fun extractVersion(filename: String, text: String): String? = when (filename) {
    "build.sbt", "Build.scala" -> SBT_SCALA_VERSION.find(text)?.groupValues?.getOrNull(1)
    ".tool-versions" -> text.lineSequence()
      .firstNotNullOfOrNull { TOOL_VERSIONS_LINE.find(it)?.groupValues?.getOrNull(1) }
    "pom.xml" -> POM_SCALA_VERSION.find(text)?.groupValues?.getOrNull(1)
      ?: POM_SCALA_PLUGIN_VERSION.find(text)?.groupValues?.getOrNull(1)
    else -> null
  }

  private companion object {
    val SBT_SCALA_VERSION = Regex("""scalaVersion\s*:=\s*"([^"]+)"""")
    val TOOL_VERSIONS_LINE = Regex("""^\s*scala\s+(\S+)""")
    val POM_SCALA_VERSION = Regex("""<scala\.version>\s*([^<\s]+)\s*</scala\.version>""")
    val POM_SCALA_PLUGIN_VERSION = Regex("""<scalaVersion>\s*([^<\s]+)\s*</scalaVersion>""")
  }
}
