package org.techsheet.cli.detector

import okio.Path
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import org.techsheet.cli.domain.ToolType

class MavenDetector : Detector(
  "Maven",
  Matcher.Filename(POM_FILE),
  Matcher.Filename(WRAPPER_SCRIPT),
  Matcher.Filename(WRAPPER_PROPERTIES),
) {

  override fun onMatch(path: Path, content: Lazy<String?>, result: DetectionResult): DetectionResult =
    result.withTool(ToolType.MAVEN, versionFor(path.name, content))

  private fun versionFor(name: String, content: Lazy<String?>): String? =
    name.takeIf { it == WRAPPER_PROPERTIES }?.let { versionFromWrapper(content.value) }

  private fun versionFromWrapper(text: String?): String? = text
    ?.lineSequence()
    ?.map(String::trim)
    ?.firstOrNull { it.startsWith(DISTRIBUTION_URL_KEY) }
    ?.substringAfter(DISTRIBUTION_URL_KEY)
    ?.let(DISTRIBUTION_URL_VERSION::find)
    ?.groupValues
    ?.getOrNull(1)

  private companion object {
    const val POM_FILE = "pom.xml"
    const val WRAPPER_SCRIPT = "mvnw"
    const val WRAPPER_PROPERTIES = "maven-wrapper.properties"
    const val DISTRIBUTION_URL_KEY = "distributionUrl="
    val DISTRIBUTION_URL_VERSION = Regex("""apache-maven-(.+?)-bin\.(zip|tar\.gz)""")
  }
}
