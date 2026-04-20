package org.techsheet.cli.detectorv2

import okio.Path
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.TechSheet

class PlayDetector : Detector("Play Framework") {

  override val matchers: List<Matcher> = listOf(
    Matcher.Filename("plugins.sbt"),
  )

  override fun onMatch(path: Path, content: Lazy<String?>, sheet: TechSheet): TechSheet =
    content.value
      ?.let { PLAY_PLUGIN.find(it)?.groupValues?.getOrNull(1) }
      ?.let { version -> sheet.withFramework(FrameworkType.PLAY_FRAMEWORK, version = version) }
      ?: sheet

  private companion object {
    // org.playframework (Play 3.x+) or com.typesafe.play (Play 2.x)
    val PLAY_PLUGIN = Regex(
      """addSbtPlugin\(\s*"(?:org\.playframework|com\.typesafe\.play)"\s*%\s*"sbt-plugin"\s*%\s*"([^"]+)"""",
    )
  }
}
