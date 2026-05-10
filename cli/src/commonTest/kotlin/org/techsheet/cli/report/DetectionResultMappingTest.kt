package org.techsheet.cli.report

import org.techsheet.cli.domain.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DetectionResultMappingTest {

  @Test
  fun `maps DetectionResult to TechSheet`() {
    val result = DetectionResult()
      .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
      .withLanguage(LanguageType.JAVASCRIPT)
      .withFramework(FrameworkType.SPRING_BOOT, version = "4.0.5")
      .withFramework(FrameworkType.JUNIT, version = "5")
      .withTool(ToolType.GRADLE, version = "9.4.1", flavor = "Kotlin DSL")
      .withTool(ToolType.GIT)

    val techSheet = result.toTechSheet()

    assertEquals(2, techSheet.schema)

    assertEquals(2, techSheet.languages.size)
    assertEquals("language.javascript", techSheet.languages[0].id)
    assertEquals("JavaScript", techSheet.languages[0].name)
    assertNull(techSheet.languages[0].version)
    assertEquals("language.kotlin", techSheet.languages[1].id)
    assertEquals("Kotlin", techSheet.languages[1].name)
    assertEquals("https://techsheet.org/language/kotlin", techSheet.languages[1].url)
    assertEquals("2.2.21", techSheet.languages[1].version)

    assertEquals(2, techSheet.frameworks.size)
    assertEquals("framework.spring-boot", techSheet.frameworks[0].id)
    assertEquals("Spring Boot", techSheet.frameworks[0].name)
    assertEquals("https://techsheet.org/framework/spring-boot", techSheet.frameworks[0].url)
    assertEquals("Application", techSheet.frameworks[0].category)
    assertEquals("4.0.5", techSheet.frameworks[0].version)
    assertEquals("framework.junit", techSheet.frameworks[1].id)
    assertEquals("JUnit", techSheet.frameworks[1].name)
    assertEquals("Testing", techSheet.frameworks[1].category)
    assertEquals("5", techSheet.frameworks[1].version)

    assertEquals(0, techSheet.services.size)

    assertEquals(2, techSheet.tools.size)
    assertEquals("tool.gradle", techSheet.tools[0].id)
    assertEquals("Gradle", techSheet.tools[0].name)
    assertEquals("https://techsheet.org/tool/gradle", techSheet.tools[0].url)
    assertEquals("Build", techSheet.tools[0].category)
    assertEquals("9.4.1", techSheet.tools[0].version)
    assertEquals("Kotlin DSL", techSheet.tools[0].flavor)
    assertEquals("tool.git", techSheet.tools[1].id)
    assertEquals("Git", techSheet.tools[1].name)
    assertEquals("VCS", techSheet.tools[1].category)
    assertNull(techSheet.tools[1].version)
    assertNull(techSheet.tools[1].flavor)
  }
}
