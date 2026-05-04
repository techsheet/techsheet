package org.techsheet.cli.detector

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
      GroovyDetector(),
      ScalaDetector(),
      JavaScriptDetector(),
      TypeScriptDetector(),
      PythonDetector(),
      PhpDetector(),
      CppDetector(),
      CSharpDetector(),
      HtmlDetector(),
      CssDetector(),
      ScssDetector(),
      MarkdownDetector(),
      AsciiDocDetector(),
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
      ComposerDetector(),
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
      ExposedDetector(),
      HibernateDetector(),
      JooqDetector(),
      SlickDetector(),
      MyBatisDetector(),
      EbeanDetector(),
      KtormDetector(),
      KafkaDetector(),
      DoctrineDetector(),
      EloquentDetector(),
      KtorDetector(),
      QuarkusDetector(),
      MicronautDetector(),
      StrutsDetector(),
      VertxDetector(),
      JakartaEeDetector(),
      DropwizardDetector(),
      HelidonDetector(),
      JavalinDetector(),
      AkkaHttpDetector(),
      Http4sDetector(),
      ApacheCxfDetector(),
      PlayDetector(),
      LaravelDetector(),
      SymfonyDetector(),
      CodeIgniterDetector(),
      ZendFrameworkDetector(),
      Yii2Detector(),
      CakePhpDetector(),
      SlimDetector(),
      PhalconDetector(),
      LumenDetector(),
      FuelPhpDetector(),
      WordPressDetector(),
      JoomlaDetector(),
      DrupalDetector(),
      MagentoDetector(),
      Typo3Detector(),
      ContaoDetector(),
      ModxDetector(),
      GravDetector(),
      ConcreteCmsDetector(),
      CraftCmsDetector(),
      DjangoDetector(),
      DjangoMarkerDetector(),
      FlaskDetector(),
      FastApiDetector(),
      ProjectReactorDetector(),
      RxJavaDetector(),
      KotlinxCoroutinesDetector(),
      AkkaDetector(),
      ZioDetector(),
      CatsEffectDetector(),
      ArrowDetector(),
      ReactPhpDetector(),
      Slf4jDetector(),
      LogbackDetector(),
      Log4j2Detector(),
      MonologDetector(),
      PlaywrightDetector(),
      PhpUnitDetector(),
      JUnitDetector(),
      MockitoDetector(),
      AssertJDetector(),
      KotestDetector(),
      ScalaTestDetector(),
      SpockDetector(),
      TestNgDetector(),
      TestcontainersDetector(),
      WireMockDetector(),
      RestAssuredDetector(),
      GitDetector(),
      ClaudeDetector(),
      GitHubCopilotDetector(),
      CursorDetector(),
      WindsurfDetector(),
      AiderDetector(),
      ContinueDetector(),
      AmazonQDetector(),
      CodeiumDetector(),
      GeminiDetector(),
      CodexDetector(),
      KiroDetector(),
      PlandexDetector(),
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
