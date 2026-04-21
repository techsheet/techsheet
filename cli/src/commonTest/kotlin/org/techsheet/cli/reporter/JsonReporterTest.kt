package org.techsheet.cli.reporter

import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import okio.Path.Companion.toPath
import okio.fakefilesystem.FakeFileSystem
import org.techsheet.cli.domain.FrameworkEntry
import org.techsheet.cli.domain.LanguageEntry
import org.techsheet.cli.domain.ReportMeta
import org.techsheet.cli.domain.ServiceEntry
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.domain.ToolEntry
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class JsonReporterTest {

  @Test
  fun `serialized json round-trips to an equal report`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.json".toPath()

    JsonReporter(path, fs).report(SAMPLE_REPORT)

    val content = fs.read(path) { readUtf8() }
    val parsed = Json.decodeFromString<TechSheetReport>(content)
    assertEquals(SAMPLE_REPORT, parsed)
  }

  @Test
  fun `serialized json omits null version fields`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.json".toPath()
    val report = TechSheetReport(
      meta = ReportMeta(
        generatedAt = Instant.parse("2026-04-21T17:37:00Z"),
        generatorVersion = "0.6.1",
      ),
      languages = listOf(
        LanguageEntry(name = "Bash", url = "https://techsheet.org/language/bash", version = null),
      ),
      frameworks = emptyList(),
      services = emptyList(),
      tools = emptyList(),
    )

    JsonReporter(path, fs).report(report)

    val content = fs.read(path) { readUtf8() }
    assertTrue(
      !content.contains("\"version\""),
      "expected no `version` key for null-version entry; got:\n$content",
    )
  }
}

private val SAMPLE_REPORT = TechSheetReport(
  meta = ReportMeta(
    generatedAt = Instant.parse("2026-04-21T17:37:00Z"),
    generatorVersion = "0.6.1",
  ),
  languages = listOf(
    LanguageEntry(name = "Java", url = "https://techsheet.org/language/java", version = "21"),
  ),
  frameworks = listOf(
    FrameworkEntry(name = "Angular", url = "https://techsheet.org/framework/angular", category = "Application", version = "21.2.4"),
  ),
  services = listOf(
    ServiceEntry(name = "Postgres", url = "https://techsheet.org/service/postgres", category = "Database", version = "16.1"),
  ),
  tools = listOf(
    ToolEntry(name = "Gradle", url = "https://techsheet.org/tool/gradle", category = "Build", version = "8.14.1", flavor = "kotlin"),
  ),
)
