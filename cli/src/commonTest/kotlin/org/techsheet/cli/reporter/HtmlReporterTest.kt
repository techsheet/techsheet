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
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HtmlReporterTest {

  @Test
  fun `emits a valid HTML5 document with doctype and the expected top-level tags`() {
    val html = render(emptyReport())

    assertTrue("<!DOCTYPE html>" in html)
    assertTrue(Regex("""<html\b""").containsMatchIn(html))
    assertTrue("<head>" in html && "</head>" in html)
    assertTrue("<body>" in html && "</body>" in html)
    assertTrue("</html>" in html)
  }

  @Test
  fun `renders meta line with generator version and human-readable timestamp`() {
    val html = render(emptyReport())

    assertTrue("v0.6.1" in html)
    assertTrue("21. April 2026 17:37" in html)
  }

  @Test
  fun `renders all four sections in L-F-S-T order with id and title`() {
    val html = render(emptyReport())

    listOf("languages" to "Languages", "frameworks" to "Frameworks", "services" to "Services", "tools" to "Tools")
      .forEach { (id, title) ->
        assertTrue(Regex("""<section\b[^>]*id="$id"""").containsMatchIn(html), "missing section id=\"$id\"")
        assertTrue(Regex("""<h2\b[^>]*>$title</h2>""").containsMatchIn(html), "missing <h2>$title</h2>")
      }

    val order = listOf("languages", "frameworks", "services", "tools")
      .map { id -> html.indexOf("""id="$id"""") }
    assertTrue(order == order.sorted() && order.none { it < 0 }, "sections not in L-F-S-T order: $order")
  }

  @Test
  fun `empty section renders a No-X notice and no table`() {
    val html = render(emptyReport())

    listOf("languages", "frameworks", "services", "tools").forEach { id ->
      val section = sectionBody(html, id)
      assertTrue("No $id" in section, "empty $id section should contain 'No $id' notice")
      assertFalse("<table" in section, "empty $id section should not contain a table")
    }
  }

  @Test
  fun `populated section renders a table with one row per entry and linkified URL`() {
    val html = render(populatedReport())

    val languages = sectionBody(html, "languages")
    assertTrue("<table" in languages)
    assertTrue("Java" in languages && "TypeScript" in languages)
    assertTrue("""<a href="https://techsheet.org/language/java">""" in languages)
    assertTrue("""<a href="https://techsheet.org/language/typescript">""" in languages)
  }

  @Test
  fun `versions are wrapped in code and missing versions render empty`() {
    val html = render(populatedReport())

    assertTrue("<code>21</code>" in html, "expected Java version in <code>")
    assertTrue("<code>5.9.3</code>" in html, "expected TypeScript version in <code>")
    // Arrow has no version; no <code>Arrow... should appear as a version
    assertFalse(Regex("""Arrow.*?<code>""", RegexOption.DOT_MATCHES_ALL).containsMatchIn(sectionBody(html, "frameworks").substringBefore("Angular").ifEmpty { "" }))
  }

  @Test
  fun `tool flavor is appended to name in parentheses`() {
    val html = render(populatedReport())

    assertTrue("Gradle (kotlin)" in html, "flavor should be shown in parentheses")
    // JUnit has no flavor — no parentheses after the name
    assertFalse(Regex("""JUnit\s*\(""").containsMatchIn(html))
  }

  @Test
  fun `escapes HTML special characters in names and versions and urls`() {
    val report = TechSheetReport(
      meta = ReportMeta(generatedAt = META_INSTANT, generatorVersion = "0.6.1"),
      languages = listOf(
        LanguageEntry(name = "C<++>", url = "https://example.com/?q=a&b=c", version = "1&2"),
      ),
      frameworks = emptyList(),
      services = emptyList(),
      tools = emptyList(),
    )

    val html = render(report)

    assertTrue("C&lt;++&gt;" in html)
    assertTrue("<code>1&amp;2</code>" in html)
    assertTrue("""<a href="https://example.com/?q=a&amp;b=c">https://example.com/?q=a&amp;b=c</a>""" in html)
    // ensure the raw unescaped forms did not leak through
    assertFalse("C<++>" in html)
    assertFalse("?q=a&b=c" in html)
  }

  private fun render(report: TechSheetReport): String {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.html".toPath()
    HtmlReporter(path, fs).report(report)
    return fs.read(path) { readUtf8() }
  }

  // Returns the substring of `html` between the opening <section id="$id" ...> and the next </section>.
  private fun sectionBody(html: String, id: String): String {
    val open = Regex("""<section\b[^>]*id="$id"[^>]*>""").find(html)
      ?: error("section id=\"$id\" not found")
    val after = html.substring(open.range.last + 1)
    val end = after.indexOf("</section>").also {
      check(it >= 0) { "section id=\"$id\" has no closing tag" }
    }
    return after.substring(0, end)
  }

  private fun emptyReport(): TechSheetReport = TechSheetReport(
    meta = ReportMeta(generatedAt = META_INSTANT, generatorVersion = "0.6.1"),
    languages = emptyList(),
    frameworks = emptyList(),
    services = emptyList(),
    tools = emptyList(),
  )

  private fun populatedReport(): TechSheetReport = TechSheetReport(
    meta = ReportMeta(generatedAt = META_INSTANT, generatorVersion = "0.6.1"),
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
