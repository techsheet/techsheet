package org.techsheet.cli.reporter

import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class MarkdownReporterTest {

  @Test
  fun `renders language name and version`() {
    val md = render(TechSheet().withLanguage(LanguageType.KOTLIN, version = "2.2.21"))

    assertContains(md, "Kotlin")
    assertContains(md, "2.2.21")
  }

  @Test
  fun `renders framework with category`() {
    val md = render(TechSheet().withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5"))

    assertContains(md, "Spring Boot")
    assertContains(md, "4.0.5")
    assertContains(md, "Application")
  }

  @Test
  fun `renders tool flavor in display name`() {
    val md = render(TechSheet().withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"))

    assertContains(md, "Gradle (Kotlin DSL)")
    assertContains(md, "9.4.1")
  }

  @Test
  fun `renders linked names with correct URLs`() {
    val md = render(
      TechSheet()
        .withLanguage(LanguageType.KOTLIN)
        .withFramework(FrameworkType.SPRING_BOOT)
        .withTool(ToolType.GRADLE),
    )

    assertContains(md, "[Kotlin](https://techsheet.org/language/kotlin)")
    assertContains(md, "[Spring Boot](https://techsheet.org/framework/spring-boot)")
    assertContains(md, "[Gradle](https://techsheet.org/tool/gradle)")
  }

  @Test
  fun `empty sheet renders section placeholders`() {
    val md = render(TechSheet())

    assertContains(md, "*No languages*")
    assertContains(md, "*No frameworks*")
    assertContains(md, "*No services*")
    assertContains(md, "*No tools*")
  }

  @Test
  fun `populated sheet omits empty-section placeholders`() {
    val md = render(
      TechSheet()
        .withLanguage(LanguageType.KOTLIN)
        .withFramework(FrameworkType.SPRING_BOOT)
        .withService(ServiceType.POSTGRES)
        .withTool(ToolType.GRADLE),
    )

    assertFalse("*No languages*" in md)
    assertFalse("*No frameworks*" in md)
    assertFalse("*No services*" in md)
    assertFalse("*No tools*" in md)
  }

  private fun render(sheet: TechSheet): String =
    ReporterFactory(TechSheetReport.of(sheet), readonly = true, fs = FakeFileSystem()).markdown.serialize()
}
