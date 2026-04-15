package org.techsheet.cli

import co.touchlab.kermit.Logger
import org.techsheet.cli.detector.*
import org.techsheet.cli.domain.TechSheet

class Analyzer(
  private val log: Logger
) {

  private val detectors = listOf(
    GradleDetector(),
    MavenDetector(),
    JavaDetector(),
    KotlinDetector(),
    ScalaDetector(),
    JavaScriptDetector(),
    TypeScriptDetector(),
    GitLabCiDetector(),
    CodeOwnersDetector(),
    DockerDetector(),
    DockerComposeDetector(),
    EditorConfigDetector(),
    RenovateDetector(),
    NpmDetector(),
    AngularDetector(),
    SpringDetector(),
    IntelliJIdeaDetector(),
    VsCodeDetector(),
  )

  fun analyze(ctx: AnalyzerContext): TechSheet = detectors
    .fold(TechSheet.empty()) { acc, detector ->
      log.i { "Running ${detector.name} detector" }
      detector.detect(ctx, acc)
    }
}
