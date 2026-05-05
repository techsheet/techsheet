package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class YamlReporterTest {

  @Test
  fun `renders language name and version`() {
    val yaml = render(TechSheet().withLanguage(LanguageType.KOTLIN, version = "2.2.21"))

    assertContains(yaml, "Kotlin")
    assertContains(yaml, """"2.2.21"""")
  }

  @Test
  fun `renders framework with category`() {
    val yaml = render(TechSheet().withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5"))

    assertContains(yaml, "Spring Boot")
    assertContains(yaml, """"4.0.5"""")
    assertContains(yaml, "Application")
  }

  @Test
  fun `renders tool flavor`() {
    val yaml = render(TechSheet().withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"))

    assertContains(yaml, "Gradle")
    assertContains(yaml, """"Kotlin DSL"""")
  }

  @Test
  fun `omits null version fields`() {
    val yaml = render(TechSheet().withLanguage(LanguageType.KOTLIN))

    assertFalse("version:" in yaml)
  }

  @Test
  fun `output round-trips through deserialization`() {
    val sheet = TechSheet()
      .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
      .withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5")
      .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL")

    val report = TechSheetReport.of(sheet)
    val yaml = render(sheet)
    val parsed = Yaml(configuration = YamlConfiguration(encodeDefaults = false, strictMode = false))
      .decodeFromString(TechSheetReport.serializer(), yaml)

    assertContains(parsed.languages.map { it.name }, "Kotlin")
    assertContains(parsed.frameworks.map { it.name }, "Spring Boot")
    assertContains(parsed.tools.map { it.name }, "Gradle")
  }

  private fun render(sheet: TechSheet): String =
    ReporterFactory(TechSheetReport.of(sheet), readonly = true, fs = FakeFileSystem()).yaml.serialize()
}
