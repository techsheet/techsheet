package org.techsheet.cli.reporter

import kotlinx.serialization.json.Json
import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.*
import org.techsheet.schema.TechSheet
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class JsonReporterTest {

  @Test
  fun `renders language name and version`() {
    val json = render(DetectionResult().withLanguage(LanguageType.KOTLIN, version = "2.2.21"))

    assertContains(json, """"Kotlin"""")
    assertContains(json, """"2.2.21"""")
  }

  @Test
  fun `renders framework with category`() {
    val json = render(DetectionResult().withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5"))

    assertContains(json, """"Spring Boot"""")
    assertContains(json, """"4.0.5"""")
    assertContains(json, """"Application"""")
  }

  @Test
  fun `omits null version fields`() {
    val json = render(DetectionResult().withLanguage(LanguageType.KOTLIN))

    assertFalse(""""version"""" in json)
  }

  @Test
  fun `output is valid JSON`() {
    val json = render(
      DetectionResult()
        .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
        .withFramework(FrameworkType.SPRING_BOOT)
        .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"),
    )

    val parsed = Json.decodeFromString<TechSheet>(json)
    assertContains(parsed.languages.map { it.name }, "Kotlin")
    assertContains(parsed.frameworks.map { it.name }, "Spring Boot")
    assertContains(parsed.tools.map { it.name }, "Gradle")
  }

  private fun render(result: DetectionResult): String =
    ReporterFactory(result.toTechSheet(), readonly = true, fs = FakeFileSystem()).json.serialize()
}
