package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.*
import org.techsheet.schema.TechSheet
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class YamlReporterTest {

  @Test
  fun `renders language name and version`() {
    val yaml = render(DetectionResult().withLanguage(LanguageType.KOTLIN, version = "2.2.21"))

    assertContains(yaml, "Kotlin")
    assertContains(yaml, """"2.2.21"""")
  }

  @Test
  fun `renders framework with category`() {
    val yaml = render(DetectionResult().withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5"))

    assertContains(yaml, "Spring Boot")
    assertContains(yaml, """"4.0.5"""")
    assertContains(yaml, "Application")
  }

  @Test
  fun `renders tool flavor`() {
    val yaml = render(DetectionResult().withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"))

    assertContains(yaml, "Gradle")
    assertContains(yaml, """"Kotlin DSL"""")
  }

  @Test
  fun `omits null version fields`() {
    val yaml = render(DetectionResult().withLanguage(LanguageType.KOTLIN))

    assertFalse("version:" in yaml)
  }

  @Test
  fun `output round-trips through deserialization`() {
    val result = DetectionResult()
      .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
      .withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5")
      .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL")

    val report = result.toTechSheet()
    val yaml = render(result)
    val parsed = Yaml(configuration = YamlConfiguration(encodeDefaults = false, strictMode = false))
      .decodeFromString(TechSheet.serializer(), yaml)

    assertContains(parsed.languages.map { it.name }, "Kotlin")
    assertContains(parsed.frameworks.map { it.name }, "Spring Boot")
    assertContains(parsed.tools.map { it.name }, "Gradle")
  }

  private fun render(result: DetectionResult): String =
    ReporterFactory(result.toTechSheet(), readonly = true, fs = FakeFileSystem()).yaml.serialize()
}
