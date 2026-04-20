package org.techsheet.cli.detectorv2

import org.techsheet.cli.domain.Matcher

class Detectors(val all: List<Detector> = ALL) {

  private val byFilename: Map<String, List<Detector>> =
    indexBy<Matcher.Filename>(all) { it.name }

  private val byExtension: Map<String, List<Detector>> =
    indexBy<Matcher.Extension>(all) { it.ext }

  private val byFileAt: Map<String, List<Detector>> =
    indexBy<Matcher.FileAt>(all) { keyOf(it.segments) }

  private val byDirectoryAt: Map<String, List<Detector>> =
    indexBy<Matcher.DirectoryAt>(all) { keyOf(it.segments) }

  fun forFile(relativePath: String, filename: String, extension: String?): List<Detector> =
    buildList {
      byFileAt[relativePath]?.let(::addAll)
      byFilename[filename]?.let(::addAll)
      extension?.let(byExtension::get)?.let(::addAll)
    }.distinct()

  fun forDirectory(relativePath: String): List<Detector> =
    byDirectoryAt[relativePath].orEmpty()

  companion object {

    val ALL: List<Detector> = listOf(
      GradleDetector(),
      MavenDetector(),
      JavaDetector(),
      KotlinDetector(),
      ScalaDetector(),
      JavaScriptDetector(),
      TypeScriptDetector(),
      PythonDetector(),
      CppDetector(),
      CSharpDetector(),
      JavaVersionDetector(),
      JVMDetector(),
      KotlinVersionDetector(),
      ScalaVersionDetector(),
      TypeScriptVersionDetector(),
      PythonVersionDetector(),
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
      AspNetCoreDetector(),
      TailwindDetector(),
      EslintDetector(),
      PrettierDetector(),
      SpringBootDetector(),
      SpringMvcDetector(),
      SpringWebFluxDetector(),
      SpringSecurityDetector(),
      SpringDataDetector(),
      PlayDetector(),
      DjangoDetector(),
      DjangoMarkerDetector(),
      FlaskDetector(),
      FastApiDetector(),
      PlaywrightDetector(),
      JUnitDetector(),
      GitDetector(),
      IntelliJIdeaDetector(),
      VsCodeDetector(),
    )

    private inline fun <reified M : Matcher> indexBy(
      detectors: List<Detector>,
      crossinline key: (M) -> String,
    ): Map<String, List<Detector>> = detectors
      .flatMap { d -> d.matchers.filterIsInstance<M>().map { key(it) to d } }
      .groupBy({ it.first }, { it.second })

    private fun keyOf(segments: List<String>): String = segments.joinToString("/")
  }
}
