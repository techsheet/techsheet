package org.techsheet.cli.reporter

import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class HtmlReporterTest {

  @Test
  fun `renders HTML5 document structure`() {
    val html = render(DetectionResult())

    assertContains(html, "<!DOCTYPE html>")
    assertContains(html, "<head>")
    assertContains(html, "<body>")
  }

  @Test
  fun `renders language name and version`() {
    val html = render(DetectionResult().withLanguage(LanguageType.KOTLIN, version = "2.2.21"))

    assertContains(html, "Kotlin")
    assertContains(html, "2.2.21")
  }

  @Test
  fun `renders framework name and version`() {
    val html = render(DetectionResult().withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5"))

    assertContains(html, "Spring Boot")
    assertContains(html, "4.0.5")
  }

  @Test
  fun `renders tool flavor in parentheses`() {
    val html = render(DetectionResult().withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"))

    assertContains(html, "Gradle (Kotlin DSL)")
    assertContains(html, "9.4.1")
  }

  @Test
  fun `renders linked names with correct URLs`() {
    val html = render(
      DetectionResult()
        .withLanguage(LanguageType.KOTLIN)
        .withFramework(FrameworkType.SPRING_BOOT)
        .withTool(ToolType.GRADLE),
    )

    assertContains(html, """<a href="https://techsheet.org/language/kotlin">Kotlin</a>""")
    assertContains(html, """<a href="https://techsheet.org/framework/spring-boot">Spring Boot</a>""")
    assertContains(html, """<a href="https://techsheet.org/tool/gradle">Gradle</a>""")
  }

  @Test
  fun `tool without flavor renders plain name`() {
    val html = render(DetectionResult().withTool(ToolType.GIT))

    assertContains(html, "Git")
    assertFalse(Regex("""Git\s*\(""").containsMatchIn(html))
  }

  private fun render(result: DetectionResult): String =
    ReporterFactory(result.toTechSheet(), readonly = true, fs = FakeFileSystem()).html.serialize()
}
