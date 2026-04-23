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
import org.techsheet.cli.domain.ReportMeta
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.reporter.YamlReporter
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail
import kotlin.time.Instant

class AnalyzerIntegrationTest {

  private val fs = FileSystem.SYSTEM
  private val log = Logger(
    config = StaticConfig(minSeverity = Severity.Warn),
    tag = "analyzer-it",
  )

  // Gradle runs tests with the module directory (cli/) as the working directory;
  // the test-projects submodule sits one level up at the repository root.
  private val testProjectsRoot = "../test-projects".toPath()

  // Deterministic meta so the generated actual.yml is reproducible across runs.
  private val fixedMeta = ReportMeta(
    generatedAt = Instant.parse("2000-01-01T00:00:00Z"),
    generatorVersion = "test",
  )

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
    val report = TechSheetReport.of(sheet).copy(meta = fixedMeta)
    YamlReporter(actualFile, fs).report(report)

    assertTrue(fs.exists(expectedFile), "missing $expectedFile")
    assertTrue(fs.exists(actualFile), "actual file $actualFile was not written")

    val expected = stripMeta(fs.read(expectedFile) { readUtf8() })
    val actual = stripMeta(fs.read(actualFile) { readUtf8() })

    assertEquals(
      expected,
      actual,
      "techsheet.actual.yml does not match techsheet.expected.yml (meta block ignored)\n${diff(expected, actual)}",
    )
  }

  // The `meta:` block holds a timestamp and generator version that are not part of
  // the detected tech sheet. Strip it from both sides so expected files can keep the
  // block (for readability) or omit it entirely — either way matches.
  private fun stripMeta(yaml: String): String {
    val out = StringBuilder()
    var inMeta = false
    for (line in yaml.lines()) {
      if (line.startsWith("meta:")) {
        inMeta = true
        continue
      }
      if (inMeta) {
        if (line.isEmpty() || line.startsWith(" ") || line.startsWith("\t")) continue
        inMeta = false
      }
      out.append(line).append('\n')
    }
    return out.toString()
  }

  private fun diff(expected: String, actual: String): String {
    val exp = expected.lines()
    val act = actual.lines()
    val sb = StringBuilder()
    val max = maxOf(exp.size, act.size)
    for (i in 0 until max) {
      val e = exp.getOrNull(i)
      val a = act.getOrNull(i)
      if (e != a) {
        if (e != null) sb.appendLine("- [${i + 1}] $e")
        if (a != null) sb.appendLine("+ [${i + 1}] $a")
      }
    }
    return sb.toString()
  }
}
