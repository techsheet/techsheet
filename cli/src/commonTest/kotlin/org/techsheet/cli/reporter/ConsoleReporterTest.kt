package org.techsheet.cli.reporter

import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.*
import kotlin.test.Test
import kotlin.test.assertContains

class ConsoleReporterTest {

  @Test
  fun `renders the expected layout`() {
    val output = render(
      TechSheet()
        .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
        .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL")
        .withTool(ToolType.INTELLIJ_IDEA)
        .withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5")
        .withFramework(FrameworkType.SPRING_MVC),
      plain = true
    )

    assertContains(output, "───── TechSheet v")
    assertContains(output, " Frameworks")
    assertContains(output, "   - Spring Boot  4.0.5  framework.spring-boot")
    assertContains(output, "   - Gradle (Kotlin DSL)  9.4.1  tool.gradle")
    assertContains(output, " IDE")
    assertContains(output, "   - IntelliJ IDEA               tool.intellij-idea")
    assertContains(output, "Total: 1 language · 2 frameworks · 0 services · 2 tools")
    assertContains(output, "───────────────────────────────────────")
  }

  @Test
  fun `renders empty sheet`() {
    val output = render(
      TechSheet(),
      plain = true
    )

    assertContains(output, "───── TechSheet v")
    assertContains(output, " Nothing detected.")
    assertContains(output, "───────────────────────────────────────")
  }

  @Test
  fun `applies ANSI colors in normal mode`() {
    val output = render(
      TechSheet()
        .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"),
      plain = false
    )

    assertContains(output, "\u001B[1;33mTools\u001B[0m")
    assertContains(output, "\u001B[32mBuild\u001B[0m")
    assertContains(output, "Gradle (Kotlin DSL)  \u001B[2m9.4.1\u001B[0m  \u001B[2mtool.gradle\u001B[0m")
  }

  @Test
  fun `applies no ANSI colors in plain mode`() {
    val output = render(
      TechSheet()
        .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL"),
      plain = true
    )

    assertContains(output, "Tools")
    assertContains(output, "Build")
    assertContains(output, "Gradle (Kotlin DSL)  9.4.1  tool.gradle")
  }

  private fun render(sheet: TechSheet, plain: Boolean) =
    ConsoleReporter(
      report = TechSheetReport.of(sheet),
      plain = plain,
      fs = FakeFileSystem()
    ).serialize()
}
