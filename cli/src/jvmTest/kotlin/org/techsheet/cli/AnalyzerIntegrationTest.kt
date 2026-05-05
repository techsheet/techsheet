package org.techsheet.cli

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.StaticConfig
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.SYSTEM
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.reporter.ReporterFactory
import org.techsheet.cli.reporter.YamlReporter
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class AnalyzerIntegrationTest {

  private val fs = FileSystem.SYSTEM
  private val log = Logger(
    config = StaticConfig(minSeverity = Severity.Warn),
    tag = "analyzer-it",
  )

  // Gradle runs tests with the module directory (cli/) as the working directory;
  // the test-projects submodule sits one level up at the repository root.
  private val testProjectsRoot = "../test-projects".toPath()

  @TestFactory
  fun `analyze test projects`(): List<DynamicTest> {
    val fixtures = fs.list(testProjectsRoot)
      .filter { fs.metadataOrNull(it)?.isDirectory == true }
      .filterNot { it.name.startsWith(".") }
      .sortedBy { it.name }

    if (fixtures.isEmpty()) {
      return listOf(DynamicTest.dynamicTest("discover fixtures") {
        fail("No fixture directories found under $testProjectsRoot")
      })
    }

    return fixtures.map { dir ->
      DynamicTest.dynamicTest(dir.name) { verify(dir) }
    }
  }

  private fun verify(dir: Path) {
    val expectedFile = dir / "techsheet.expected.yml"
    val actualFile = dir / "techsheet.actual.yml"

    val ctx = AnalyzerContext(path = dir, log = log)
    val sheet = Analyzer(log).analyze(ctx)

    //TODO: YamlReporter(actualFile, fs).report(TechSheetReport.of(sheet))

    ReporterFactory(TechSheetReport.of(sheet), readonly = false, fs = fs)
      .yaml
      .report(actualFile)

    assertTrue(fs.exists(expectedFile), "missing $expectedFile")
    assertTrue(fs.exists(actualFile), "actual file $actualFile was not written")

    val expected = fs.read(expectedFile) { readUtf8() }
    val actual = fs.read(actualFile) { readUtf8() }

    assertEquals(expected, actual, "techsheet.actual.yml does not match techsheet.expected.yml")
  }
}
