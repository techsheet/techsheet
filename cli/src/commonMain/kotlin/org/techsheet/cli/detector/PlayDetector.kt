package org.techsheet.cli.detector

import org.techsheet.cli.AnalyzerContext
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.TechnologyType

class PlayDetector : Detector("Play Framework") {

  private val depth = 3

  override fun detect(ctx: AnalyzerContext, sheet: TechSheet): TechSheet =
    ctx.walk(depth)
      .filter { it.name == "plugins.sbt" }
      .firstNotNullOfOrNull { ctx.readFileContents(it) }
      ?.let { PLAY_PLUGIN.find(it)?.groupValues?.get(1) }
      ?.let { version -> sheet.withTechnology(TechnologyType.PLAY_FRAMEWORK, version = version) }
      ?: sheet

  companion object {
    // org.playframework (Play 3.x+) or com.typesafe.play (Play 2.x)
    private val PLAY_PLUGIN = Regex(
      """addSbtPlugin\(\s*"(?:org\.playframework|com\.typesafe\.play)"\s*%\s*"sbt-plugin"\s*%\s*"([^"]+)"""",
    )
  }
}
