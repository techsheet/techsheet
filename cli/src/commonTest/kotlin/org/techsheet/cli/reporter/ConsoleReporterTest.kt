package org.techsheet.cli.reporter

import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet
import org.techsheet.cli.domain.ToolType
import kotlin.test.Test
import kotlin.test.assertEquals

class ConsoleReporterTest {

  private fun render(sheet: TechSheet, plain: Boolean = true): List<String> {
    val sink = mutableListOf<String>()
    ConsoleReporter(plain = plain, emit = sink::add).report(sheet)
    return sink
  }

  @Test
  fun `renders the expected layout`() {
    val sheet = TechSheet()
      .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
      .withTool(ToolType.GRADLE_KOTLIN, version = "9.4.1")
      .withTool(ToolType.INTELLIJ_IDEA)
      .withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5")
      .withFramework(FrameworkType.SPRING_MVC)
    val expected = listOf(
      "",
      "─".repeat(5) + " TechSheet " + "─".repeat(60 - 16),
      "",
      " Languages",
      "   - Kotlin 2.2.21",
      "",
      " Frameworks",
      " Application",
      "   - Spring Boot 4.0.5",
      "   - Spring MVC",
      "",
      " Tools",
      " Build",
      "   - Gradle - Kotlin DSL 9.4.1",
      " IDE",
      "   - IntelliJ IDEA",
      "",
      " Total: 1 language · 2 frameworks · 2 tools",
      "─".repeat(60),
      "",
    )
    assertEquals(expected, render(sheet))
  }

  @Test
  fun `renders empty sheet`() {
    val expected = listOf(
      "",
      "─".repeat(5) + " TechSheet " + "─".repeat(60 - 16),
      "",
      " Nothing detected.",
      "─".repeat(60),
      "",
    )
    assertEquals(expected, render(TechSheet()))
  }

  @Test
  fun `applies ANSI colors in normal mode`() {
    val sheet = TechSheet().withTool(ToolType.GRADLE_KOTLIN, version = "9.4.1")
    val sink = mutableListOf<String>()
    ConsoleReporter(plain = false, emit = sink::add).report(sheet)
    assertEquals(" \u001B[1;33mTools\u001B[0m", sink.single { it.endsWith("Tools\u001B[0m") })
    assertEquals(" \u001B[32mBuild\u001B[0m", sink.single { it.contains("Build") })
    assertEquals(
      "   Gradle - Kotlin DSL \u001B[2m9.4.1\u001B[0m",
      sink.single { it.contains("Gradle") },
    )
  }

  @Test
  fun `applies no ANSI colors in plain mode`() {
    val sheet = TechSheet().withTool(ToolType.GRADLE_KOTLIN, version = "9.4.1")
    val sink = mutableListOf<String>()
    ConsoleReporter(plain = true, emit = sink::add).report(sheet)
    assertEquals(" Tools", sink.single { it.contains("Tools") })
    assertEquals(" Build", sink.single { it.contains("Build") })
    assertEquals("   - Gradle - Kotlin DSL 9.4.1", sink.single { it.contains("Gradle") })
  }
}
