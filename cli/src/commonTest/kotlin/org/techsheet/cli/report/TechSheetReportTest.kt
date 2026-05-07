package org.techsheet.cli.report

import org.techsheet.cli.domain.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class TechSheetReportTest {

  @Test
  fun `maps a TechSheet to TechSheetReport`() {
    val sheet = TechSheet()
      .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
      .withLanguage(LanguageType.JAVASCRIPT)
      .withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5")
      .withFramework(FrameworkType.JUNIT, version = "5")
      .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL")
      .withTool(ToolType.GIT)

    val report = TechSheetReport.of(sheet)

    assertEquals(1, report.schema)

    assertEquals(2, report.languages.size)
    assertEquals("language.javascript", report.languages[0].id)
    assertEquals("JavaScript", report.languages[0].name)
    assertNull(report.languages[0].version)
    assertEquals("language.kotlin", report.languages[1].id)
    assertEquals("Kotlin", report.languages[1].name)
    assertEquals("https://techsheet.org/language/kotlin", report.languages[1].url)
    assertEquals("2.2.21", report.languages[1].version)

    assertEquals(2, report.frameworks.size)
    assertEquals("framework.spring-boot", report.frameworks[0].id)
    assertEquals("Spring Boot", report.frameworks[0].name)
    assertEquals("https://techsheet.org/framework/spring-boot", report.frameworks[0].url)
    assertEquals("Application", report.frameworks[0].category)
    assertEquals("4.0.5", report.frameworks[0].version)
    assertEquals("framework.junit", report.frameworks[1].id)
    assertEquals("JUnit", report.frameworks[1].name)
    assertEquals("Testing", report.frameworks[1].category)
    assertEquals("5", report.frameworks[1].version)

    assertEquals(0, report.services.size)

    assertEquals(2, report.tools.size)
    assertEquals("tool.gradle", report.tools[0].id)
    assertEquals("Gradle", report.tools[0].name)
    assertEquals("https://techsheet.org/tool/gradle", report.tools[0].url)
    assertEquals("Build", report.tools[0].category)
    assertEquals("9.4.1", report.tools[0].version)
    assertEquals("Kotlin DSL", report.tools[0].flavor)
    assertEquals("tool.git", report.tools[1].id)
    assertEquals("Git", report.tools[1].name)
    assertEquals("VCS", report.tools[1].category)
    assertNull(report.tools[1].version)
    assertNull(report.tools[1].flavor)
  }
}
