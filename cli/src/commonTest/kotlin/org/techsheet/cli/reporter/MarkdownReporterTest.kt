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
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MarkdownReporterTest {

  @Test
  fun `renders empty sheet with four empty-section notices`() {
    val output = render(emptyReport())

    assertTrue(output.contains("## Languages\n\n*No languages*"))
    assertTrue(output.contains("## Frameworks\n\n*No frameworks*"))
    assertTrue(output.contains("## Services\n\n*No services*"))
    assertTrue(output.contains("## Tools\n\n*No tools*"))
  }

  @Test
  fun `renders meta line`() {
    val output = render(emptyReport())
    assertTrue(output.contains("`21. April 2026 17:37` ‧ `v0.6.1`"))
  }

  @Test
  fun `renders sections in L-F-S-T order`() {
    val output = render(emptyReport())
    val langPos = output.indexOf("## Languages")
    val fwPos = output.indexOf("## Frameworks")
    val svcPos = output.indexOf("## Services")
    val toolPos = output.indexOf("## Tools")
    assertTrue(langPos < fwPos && fwPos < svcPos && svcPos < toolPos)
  }

  @Test
  fun `language table has correct headers and cell content`() {
    val rows = render(populatedReport()).tableRows("Languages")

    assertEquals(listOf("Name", "Version", "ID", "Notes"), rows[0])
    assertEquals(listOf("[Java](https://techsheet.org/language/java)", "`21`", "`language.java`", ""), rows[1])
    assertEquals(listOf("[TypeScript](https://techsheet.org/language/typescript)", "`5.9.3`", "`language.typescript`", ""), rows[2])
  }

  @Test
  fun `framework table has correct headers and cell content`() {
    val rows = render(populatedReport()).tableRows("Frameworks")

    assertEquals(listOf("Name", "Version", "Category", "ID", "Notes"), rows[0])
    assertEquals(listOf("[Angular](https://techsheet.org/framework/angular)", "`21.2.4`", "Application", "`framework.angular`", ""), rows[1])
    assertEquals(listOf("[Arrow](https://techsheet.org/framework/arrow)", "", "Concurrency", "`framework.arrow`", ""), rows[2])
  }

  @Test
  fun `service table has correct headers and cell content`() {
    val rows = render(populatedReport()).tableRows("Services")

    assertEquals(listOf("Name", "Version", "Category", "ID", "Notes"), rows[0])
    assertEquals(listOf("[Postgres](https://techsheet.org/service/postgres)", "`16.1`", "Database", "`service.postgres`", ""), rows[1])
  }

  @Test
  fun `tool table uses display name and has correct headers and cell content`() {
    val rows = render(populatedReport()).tableRows("Tools")

    assertEquals(listOf("Name", "Version", "Category", "ID", "Notes"), rows[0])
    assertEquals(listOf("[Gradle (kotlin)](https://techsheet.org/tool/gradle)", "`8.14.1`", "Build", "`tool.gradle`", ""), rows[1])
    assertEquals(listOf("[JUnit](https://techsheet.org/tool/junit)", "`5.11.4`", "Testing", "`tool.junit`", ""), rows[2])
  }

  @Test
  fun `populated section replaces empty notice`() {
    val output = render(populatedReport())
    assertFalse(output.contains("*No languages*"))
    assertFalse(output.contains("*No frameworks*"))
    assertFalse(output.contains("*No services*"))
    assertFalse(output.contains("*No tools*"))
  }

  // ---------- helpers ----------

  private fun render(report: TechSheetReport): String {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.md".toPath()
    MarkdownReporter(path, fs).report(report)
    return fs.read(path) { readUtf8() }
  }

  private fun String.tableRows(section: String): List<List<String>> {
    val start = indexOf("## $section\n")
    val end = indexOf("\n## ", start + 1).let { if (it == -1) length else it }
    return substring(start, end)
      .lines()
      .filter { it.startsWith('|') }
      .filterNot { it.matches(Regex("""\|[-| ]+\|""")) }
      .map { row -> row.split('|').drop(1).dropLast(1).map { it.trim() } }
      .filter { cells -> cells.any { it.isNotEmpty() } }
  }

  private fun emptyReport() = TechSheetReport(
    meta = ReportMeta(generatedAt = META_INSTANT, generatorVersion = "0.6.1"),
    languages = emptyList(),
    frameworks = emptyList(),
    services = emptyList(),
    tools = emptyList(),
  )

  private fun populatedReport() = TechSheetReport(
    meta = ReportMeta(generatedAt = META_INSTANT, generatorVersion = "0.6.1"),
    languages = listOf(
      LanguageEntry(id = "language.java", name = "Java", url = "https://techsheet.org/language/java", version = "21"),
      LanguageEntry(id = "language.typescript", name = "TypeScript", url = "https://techsheet.org/language/typescript", version = "5.9.3"),
    ),
    frameworks = listOf(
      FrameworkEntry(id = "framework.angular", name = "Angular", category = "Application", url = "https://techsheet.org/framework/angular", version = "21.2.4"),
      FrameworkEntry(id = "framework.arrow", name = "Arrow", category = "Concurrency", url = "https://techsheet.org/framework/arrow", version = null),
    ),
    services = listOf(
      ServiceEntry(id = "service.postgres", name = "Postgres", category = "Database", url = "https://techsheet.org/service/postgres", version = "16.1"),
    ),
    tools = listOf(
      ToolEntry(id = "tool.gradle", name = "Gradle", category = "Build", url = "https://techsheet.org/tool/gradle", version = "8.14.1", flavor = "kotlin"),
      ToolEntry(id = "tool.junit", name = "JUnit", category = "Testing", url = "https://techsheet.org/tool/junit", version = "5.11.4"),
    ),
  )
}

// Constructed so that toLocalDateTime(currentSystemDefault()) round-trips to
// 2026-04-21T17:37 regardless of the runner's time zone.
private val META_INSTANT: Instant =
  LocalDateTime(2026, Month.APRIL, 21, 17, 37)
    .toInstant(TimeZone.currentSystemDefault())
