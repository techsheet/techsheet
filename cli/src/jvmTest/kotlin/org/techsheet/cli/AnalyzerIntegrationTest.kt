package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import okio.Path.Companion.toOkioPath
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.techsheet.cli.domain.TechnologyType
import org.techsheet.cli.domain.ToolType
import org.techsheet.cli.domain.ProgrammingLanguageType
import org.techsheet.cli.domain.TechSheet
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AnalyzerIntegrationTest {

  private val cases = listOf(
    testCase("kotlin-spring-boot-gradle") {
      TechSheet()
        .withTool(ToolType.GRADLE_KOTLIN, version = "9.4.1")
        .withTechnology(TechnologyType.SPRING_BOOT, version = "4.0.5")
        .withTechnology(TechnologyType.SPRING_MVC)
        .withProgrammingLanguage(ProgrammingLanguageType.KOTLIN, version = "2.2.21")
    },
    testCase("java-spring-boot-maven") {
      TechSheet()
        .withTool(ToolType.MAVEN, version = "3.9.14")
        .withTechnology(TechnologyType.SPRING_BOOT, version = "3.5.13")
        .withTechnology(TechnologyType.SPRING_SECURITY)
        .withTechnology(TechnologyType.SPRING_DATA)
        .withProgrammingLanguage(ProgrammingLanguageType.JAVA, version = "17")
    },
    testCase("angular") {
      TechSheet()
        .withProgrammingLanguage(ProgrammingLanguageType.TYPESCRIPT, version = "5.9.2")
        .withTool(ToolType.EDITORCONFIG)
        .withTool(ToolType.NPM)
        .withTechnology(TechnologyType.ANGULAR, version = "20.3.0")
        .withTool(ToolType.VS_CODE)
    },
    testCase("play-scala-seed") {
      TechSheet()
        .withProgrammingLanguage(ProgrammingLanguageType.Scala, version = "2.13.18")
        .withProgrammingLanguage(ProgrammingLanguageType.JAVASCRIPT)
        .withTool(ToolType.SBT, version = "1.12.9")
        .withTechnology(TechnologyType.PLAY_FRAMEWORK, version = "3.0.10")
    },
    testCase("playwright") {
      TechSheet()
        .withProgrammingLanguage(ProgrammingLanguageType.TYPESCRIPT)
        .withTool(ToolType.GITHUB_ACTIONS)
        .withTool(ToolType.NPM)
        .withTool(ToolType.YARN)
        .withTechnology(TechnologyType.PLAYWRIGHT, version = "1.59.1")
    },
    testCase("ci-tools") {
      TechSheet()
        .withTool(ToolType.GITLAB_CI)
        .withTool(ToolType.CODEOWNERS)
        .withTool(ToolType.DOCKER)
        .withTool(ToolType.DOCKER_COMPOSE)
        .withTool(ToolType.EDITORCONFIG)
        .withTool(ToolType.RENOVATE)
    },
  )

  private val log = Logger(
    config = StaticConfig(minSeverity = Severity.Warn),
    tag = "analyzer-it",
  )

  @TestFactory
  fun `analyze test projects`(): List<DynamicTest> = cases.map { case ->
    DynamicTest.dynamicTest(case.name) {
      val ctx = AnalyzerContext(path = fixturePath("test-projects/${case.name}"), log = log)
      val actual = Analyzer(log).analyze(ctx)
      assertEquals(case.expected, actual, "Unexpected tech sheet for test project '${case.name}'")
    }
  }

  private data class Case(val name: String, val expected: TechSheet)

  private fun testCase(name: String, block: () -> TechSheet): Case =
    Case(name = name, expected = block())

  private fun fixturePath(resource: String): okio.Path {
    val url = assertNotNull(
      this::class.java.classLoader.getResource(resource),
      "Test fixture not found on classpath: $resource",
    )
    return Paths.get(url.toURI()).toOkioPath()
  }
}
