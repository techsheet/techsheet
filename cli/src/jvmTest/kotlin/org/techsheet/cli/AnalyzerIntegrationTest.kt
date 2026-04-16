package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import okio.Path.Companion.toOkioPath
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.techsheet.cli.domain.TechnologyType
import org.techsheet.cli.domain.ToolType
import org.techsheet.cli.domain.LanguageType
import org.techsheet.cli.domain.TechSheet
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AnalyzerIntegrationTest {

  private val cases = listOf(
    testCase("groovy-spring-boot-gradle") {
      TechSheet()
        .withTool(ToolType.GRADLE_GROOVY, version = "9.4.1")
        .withTool(ToolType.INTELLIJ_IDEA)
        .withTechnology(TechnologyType.SPRING_BOOT, version = "4.0.5")
        .withTechnology(TechnologyType.SPRING_WEBFLUX)
        .withTechnology(TechnologyType.JUNIT, version = "5")
    },
    testCase("kotlin-spring-boot-gradle") {
      TechSheet()
        .withTool(ToolType.GRADLE_KOTLIN, version = "9.4.1")
        .withTechnology(TechnologyType.SPRING_BOOT, version = "4.0.5")
        .withTechnology(TechnologyType.SPRING_MVC)
        .withTechnology(TechnologyType.JUNIT, version = "5")
        .withLanguage(LanguageType.KOTLIN, version = "2.2.21")
    },
    testCase("java-spring-boot-maven") {
      TechSheet()
        .withTool(ToolType.MAVEN, version = "3.9.14")
        .withTechnology(TechnologyType.SPRING_BOOT, version = "3.5.13")
        .withTechnology(TechnologyType.SPRING_SECURITY)
        .withTechnology(TechnologyType.SPRING_DATA)
        .withLanguage(LanguageType.JAVA, version = "17")
    },
    testCase("angular") {
      TechSheet()
        .withLanguage(LanguageType.TYPESCRIPT, version = "5.9.2")
        .withTool(ToolType.EDITORCONFIG)
        .withTool(ToolType.NPM)
        .withTechnology(TechnologyType.ANGULAR, version = "20.3.0")
        .withTool(ToolType.VS_CODE)
    },
    testCase("python_django") {
      TechSheet()
        .withLanguage(LanguageType.PYTHON)
        .withTechnology(TechnologyType.DJANGO)
    },
    testCase("python_flask") {
      TechSheet()
        .withLanguage(LanguageType.PYTHON)
        .withTechnology(TechnologyType.FLASK, version = "3.0.3")
    },
    testCase("python_fastapi") {
      TechSheet()
        .withLanguage(LanguageType.PYTHON, version = "3.12")
        .withTechnology(TechnologyType.FASTAPI, version = "0.115.0")
    },
    testCase("play-scala-seed") {
      TechSheet()
        .withLanguage(LanguageType.SCALA, version = "2.13.18")
        .withLanguage(LanguageType.JAVASCRIPT)
        .withTool(ToolType.SBT, version = "1.12.9")
        .withTechnology(TechnologyType.PLAY_FRAMEWORK, version = "3.0.10")
    },
    testCase("playwright") {
      TechSheet()
        .withLanguage(LanguageType.TYPESCRIPT)
        .withTool(ToolType.GITHUB_ACTIONS)
        .withTool(ToolType.NPM)
        .withTool(ToolType.YARN)
        .withTechnology(TechnologyType.PLAYWRIGHT, version = "1.59.1")
    },
    testCase("next-js") {
      TechSheet()
        .withLanguage(LanguageType.TYPESCRIPT, version = "5")
        .withTool(ToolType.NPM)
        .withTool(ToolType.ESLINT, version = "9")
        .withTechnology(TechnologyType.REACT, version = "19.2.4")
        .withTechnology(TechnologyType.NEXT, version = "16.2.4")
        .withTechnology(TechnologyType.TAILWIND, version = "4")
    },
    testCase("node-express") {
      TechSheet()
        .withLanguage(LanguageType.JAVASCRIPT)
        .withTool(ToolType.NPM)
        .withTool(ToolType.NODE)
        .withTechnology(TechnologyType.EXPRESS, version = "4.16.1")
    },
    testCase("qt-cmake-app") {
      TechSheet()
        .withLanguage(LanguageType.CPP)
        .withTechnology(TechnologyType.QT, version = "6")
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
