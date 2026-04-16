package org.techsheet.cli

import co.touchlab.kermit.Logger
import org.techsheet.cli.detector.*
import org.techsheet.cli.domain.TechSheet

class Analyzer(
  private val log: Logger
) {

  fun analyze(ctx: AnalyzerContext): TechSheet = ALL_DETECTORS
    .fold(TechSheet.empty()) { acc, detector ->
      log.i { "Running ${detector.name} detector" }
      detector.detect(ctx, acc)
    }

  companion object {
    val ALL_DETECTORS: List<Detector> = listOf(
      GradleDetector(),
      MavenDetector(),
      JavaDetector(),
      KotlinDetector(),
      ScalaDetector(),
      JavaScriptDetector(),
      TypeScriptDetector(),
      PythonDetector(),
      CppDetector(),
      GitLabCiDetector(),
      GitHubActionsDetector(),
      CodeOwnersDetector(),
      DockerDetector(),
      DockerComposeDetector(),
      EditorConfigDetector(),
      RenovateDetector(),
      NpmDetector(),
      YarnDetector(),
      NodeDetector(),
      SbtDetector(),
      AngularDetector(),
      ReactDetector(),
      VueDetector(),
      SvelteDetector(),
      NextDetector(),
      ExpressDetector(),
      QtDetector(),
      TailwindDetector(),
      EslintDetector(),
      PrettierDetector(),
      SpringDetector(),
      PlayDetector(),
      DjangoDetector(),
      FlaskDetector(),
      FastApiDetector(),
      PlaywrightDetector(),
      JUnitDetector(),
      GitDetector(),
      IntelliJIdeaDetector(),
      VsCodeDetector(),
    )
  }
}
