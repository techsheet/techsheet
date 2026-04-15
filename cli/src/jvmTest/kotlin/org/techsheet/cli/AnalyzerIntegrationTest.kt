package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import okio.Path.Companion.toOkioPath
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.techsheet.cli.domain.BuildToolType
import org.techsheet.cli.domain.ProgrammingLanguageType
import org.techsheet.cli.domain.TechSheet
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AnalyzerIntegrationTest {

  private val cases = listOf(
    testCase("kotlin-spring-boot-gradle") {
      TechSheet()
        .withBuildTool(BuildToolType.GRADLE_KOTLIN, version = "9.4.1")
        .withProgrammingLanguage(ProgrammingLanguageType.KOTLIN, version = "2.2.21")
    },
    testCase("java-spring-boot-maven") {
      TechSheet()
        .withBuildTool(BuildToolType.MAVEN, version = "3.9.14")
        .withProgrammingLanguage(ProgrammingLanguageType.JAVA, version = "17")
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
