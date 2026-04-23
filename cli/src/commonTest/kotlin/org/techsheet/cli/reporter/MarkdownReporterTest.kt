package org.techsheet.cli.reporter

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.time.Instant
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

class MarkdownReporterTest {

  @Test
  fun `renders empty sheet as header and meta with four empty-section notices`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.md".toPath()

    MarkdownReporter(path, fs).report(emptyReport())

    val actual = fs.read(path) { readUtf8() }
    val expected = """
      |# TechSheet
      |
      |`21. April 2026 17:37` ‧ `v0.6.1`
      |
      |## Languages
      |
      |*No languages*
      |
      |## Frameworks
      |
      |*No frameworks*
      |
      |## Services
      |
      |*No services*
      |
      |## Tools
      |
      |*No tools*
      |
    """.trimMargin()
    assertEquals(expected, actual)
  }

  @Test
  fun `renders a populated sheet with aligned tables in L-F-S-T order`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.md".toPath()

    MarkdownReporter(path, fs).report(populatedReport())

    val actual = fs.read(path) { readUtf8() }
    val expected = """
      |# TechSheet
      |
      |`21. April 2026 17:37` ‧ `v0.6.1`
      |
      |## Languages
      |
      || Name       | Version | URL                                       | Notes |
      ||------------|---------|-------------------------------------------|-------|
      || Java       | `21`    | https://techsheet.org/language/java       |       |
      || TypeScript | `5.9.3` | https://techsheet.org/language/typescript |       |
      ||            |         |                                           |       |
      |
      |## Frameworks
      |
      || Name    | Version  | Category    | URL                                     | Notes |
      ||---------|----------|-------------|-----------------------------------------|-------|
      || Angular | `21.2.4` | Application | https://techsheet.org/framework/angular |       |
      || Arrow   |          | Concurrency | https://techsheet.org/framework/arrow   |       |
      ||         |          |             |                                         |       |
      |
      |## Services
      |
      || Name     | Version | Category | URL                                    | Notes |
      ||----------|---------|----------|----------------------------------------|-------|
      || Postgres | `16.1`  | Database | https://techsheet.org/service/postgres |       |
      ||          |         |          |                                        |       |
      |
      |## Tools
      |
      || Name            | Version  | Category | URL                               | Notes |
      ||-----------------|----------|----------|-----------------------------------|-------|
      || Gradle (kotlin) | `8.14.1` | Build    | https://techsheet.org/tool/gradle |       |
      || JUnit           | `5.11.4` | Testing  | https://techsheet.org/tool/junit  |       |
      ||                 |          |          |                                   |       |
      |
    """.trimMargin()
    assertEquals(expected, actual)
  }

  @Test
  fun `renders mixed sheet with one populated and three empty sections`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.md".toPath()

    val report = TechSheetReport(
      meta = ReportMeta(
        generatedAt = META_INSTANT,
        generatorVersion = "0.6.1",
      ),
      languages = listOf(
        LanguageEntry(name = "Java", url = "https://techsheet.org/language/java", version = "21"),
      ),
      frameworks = emptyList(),
      services = emptyList(),
      tools = emptyList(),
    )

    MarkdownReporter(path, fs).report(report)

    val actual = fs.read(path) { readUtf8() }
    val expected = """
      |# TechSheet
      |
      |`21. April 2026 17:37` ‧ `v0.6.1`
      |
      |## Languages
      |
      || Name | Version | URL                                 | Notes |
      ||------|---------|-------------------------------------|-------|
      || Java | `21`    | https://techsheet.org/language/java |       |
      ||      |         |                                     |       |
      |
      |## Frameworks
      |
      |*No frameworks*
      |
      |## Services
      |
      |*No services*
      |
      |## Tools
      |
      |*No tools*
      |
    """.trimMargin()
    assertEquals(expected, actual)
  }

  private fun emptyReport(): TechSheetReport = TechSheetReport(
    meta = ReportMeta(
      generatedAt = META_INSTANT,
      generatorVersion = "0.6.1",
    ),
    languages = emptyList(),
    frameworks = emptyList(),
    services = emptyList(),
    tools = emptyList(),
  )

  private fun populatedReport(): TechSheetReport = TechSheetReport(
    meta = ReportMeta(
      generatedAt = META_INSTANT,
      generatorVersion = "0.6.1",
    ),
    languages = listOf(
      LanguageEntry(name = "Java", url = "https://techsheet.org/language/java", version = "21"),
      LanguageEntry(name = "TypeScript", url = "https://techsheet.org/language/typescript", version = "5.9.3"),
    ),
    frameworks = listOf(
      FrameworkEntry(name = "Angular", url = "https://techsheet.org/framework/angular", category = "Application", version = "21.2.4"),
      FrameworkEntry(name = "Arrow", url = "https://techsheet.org/framework/arrow", category = "Concurrency", version = null),
    ),
    services = listOf(
      ServiceEntry(name = "Postgres", url = "https://techsheet.org/service/postgres", category = "Database", version = "16.1"),
    ),
    tools = listOf(
      ToolEntry(name = "Gradle", url = "https://techsheet.org/tool/gradle", category = "Build", version = "8.14.1", flavor = "kotlin"),
      ToolEntry(name = "JUnit", url = "https://techsheet.org/tool/junit", category = "Testing", version = "5.11.4", flavor = null),
    ),
  )
}

// Constructed so that toLocalDateTime(currentSystemDefault()) round-trips to
// 2026-04-21T17:37 regardless of the runner's time zone.
private val META_INSTANT: Instant =
  LocalDateTime(2026, Month.APRIL, 21, 17, 37)
    .toInstant(TimeZone.currentSystemDefault())
