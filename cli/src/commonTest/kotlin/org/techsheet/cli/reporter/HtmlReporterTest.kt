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

class HtmlReporterTest {

  @Test
  fun `renders empty sheet with four empty-section notices inside sections`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.html".toPath()

    HtmlReporter(path, fs).report(emptyReport())

    val actual = fs.read(path) { readUtf8() }
    val expected = """
      |<!DOCTYPE html>
      |<html lang="en">
      |<head>
      |  <meta charset="utf-8">
      |  <meta name="viewport" content="width=device-width, initial-scale=1">
      |  <title>TechSheet</title>
      |  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
      |        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
      |</head>
      |<body>
      |<main class="container-fluid py-5 px-5">
      |
      |  <h1 class="display-2">TechSheet</h1>
      |  <p><code>21. April 2026 17:37</code> ‧ <code>v0.6.1</code></p>
      |
      |  <section id="languages" class="py-5">
      |    <h2>Languages</h2>
      |    <p><em>No languages</em></p>
      |  </section>
      |
      |  <section id="frameworks" class="py-5">
      |    <h2>Frameworks</h2>
      |    <p><em>No frameworks</em></p>
      |  </section>
      |
      |  <section id="services" class="py-5">
      |    <h2>Services</h2>
      |    <p><em>No services</em></p>
      |  </section>
      |
      |  <section id="tools" class="py-5">
      |    <h2>Tools</h2>
      |    <p><em>No tools</em></p>
      |  </section>
      |</main>
      |
      |<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
      |        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
      |        crossorigin="anonymous"></script>
      |</body>
      |</html>
      |
    """.trimMargin()
    assertEquals(expected, actual)
  }

  @Test
  fun `renders a populated sheet with tables in L-F-S-T order`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.html".toPath()

    HtmlReporter(path, fs).report(populatedReport())

    val actual = fs.read(path) { readUtf8() }
    val expected = """
      |<!DOCTYPE html>
      |<html lang="en">
      |<head>
      |  <meta charset="utf-8">
      |  <meta name="viewport" content="width=device-width, initial-scale=1">
      |  <title>TechSheet</title>
      |  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
      |        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
      |</head>
      |<body>
      |<main class="container-fluid py-5 px-5">
      |
      |  <h1 class="display-2">TechSheet</h1>
      |  <p><code>21. April 2026 17:37</code> ‧ <code>v0.6.1</code></p>
      |
      |  <section id="languages" class="py-5">
      |    <h2>Languages</h2>
      |    <table class="table table-hover">
      |      <thead>
      |      <tr>
      |        <th>Name</th>
      |        <th>Version</th>
      |        <th>URL</th>
      |        <th>Notes</th>
      |      </tr>
      |      </thead>
      |      <tbody>
      |      <tr>
      |        <td>Java</td>
      |        <td><code>21</code></td>
      |        <td><a href="https://techsheet.org/language/java">https://techsheet.org/language/java</a></td>
      |        <td></td>
      |      </tr>
      |      <tr>
      |        <td>TypeScript</td>
      |        <td><code>5.9.3</code></td>
      |        <td><a href="https://techsheet.org/language/typescript">https://techsheet.org/language/typescript</a></td>
      |        <td></td>
      |      </tr>
      |      </tbody>
      |    </table>
      |  </section>
      |
      |  <section id="frameworks" class="py-5">
      |    <h2>Frameworks</h2>
      |    <table class="table table-hover">
      |      <thead>
      |      <tr>
      |        <th>Name</th>
      |        <th>Version</th>
      |        <th>Category</th>
      |        <th>URL</th>
      |        <th>Notes</th>
      |      </tr>
      |      </thead>
      |      <tbody>
      |      <tr>
      |        <td>Angular</td>
      |        <td><code>21.2.4</code></td>
      |        <td>Application</td>
      |        <td><a href="https://techsheet.org/framework/angular">https://techsheet.org/framework/angular</a></td>
      |        <td></td>
      |      </tr>
      |      <tr>
      |        <td>Arrow</td>
      |        <td></td>
      |        <td>Concurrency</td>
      |        <td><a href="https://techsheet.org/framework/arrow">https://techsheet.org/framework/arrow</a></td>
      |        <td></td>
      |      </tr>
      |      </tbody>
      |    </table>
      |  </section>
      |
      |  <section id="services" class="py-5">
      |    <h2>Services</h2>
      |    <table class="table table-hover">
      |      <thead>
      |      <tr>
      |        <th>Name</th>
      |        <th>Version</th>
      |        <th>Category</th>
      |        <th>URL</th>
      |        <th>Notes</th>
      |      </tr>
      |      </thead>
      |      <tbody>
      |      <tr>
      |        <td>Postgres</td>
      |        <td><code>16.1</code></td>
      |        <td>Database</td>
      |        <td><a href="https://techsheet.org/service/postgres">https://techsheet.org/service/postgres</a></td>
      |        <td></td>
      |      </tr>
      |      </tbody>
      |    </table>
      |  </section>
      |
      |  <section id="tools" class="py-5">
      |    <h2>Tools</h2>
      |    <table class="table table-hover">
      |      <thead>
      |      <tr>
      |        <th>Name</th>
      |        <th>Version</th>
      |        <th>Category</th>
      |        <th>URL</th>
      |        <th>Notes</th>
      |      </tr>
      |      </thead>
      |      <tbody>
      |      <tr>
      |        <td>Gradle (kotlin)</td>
      |        <td><code>8.14.1</code></td>
      |        <td>Build</td>
      |        <td><a href="https://techsheet.org/tool/gradle">https://techsheet.org/tool/gradle</a></td>
      |        <td></td>
      |      </tr>
      |      <tr>
      |        <td>JUnit</td>
      |        <td><code>5.11.4</code></td>
      |        <td>Testing</td>
      |        <td><a href="https://techsheet.org/tool/junit">https://techsheet.org/tool/junit</a></td>
      |        <td></td>
      |      </tr>
      |      </tbody>
      |    </table>
      |  </section>
      |</main>
      |
      |<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
      |        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
      |        crossorigin="anonymous"></script>
      |</body>
      |</html>
      |
    """.trimMargin()
    assertEquals(expected, actual)
  }

  @Test
  fun `escapes HTML special characters in names and urls`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.html".toPath()

    val report = TechSheetReport(
      meta = ReportMeta(generatedAt = META_INSTANT, generatorVersion = "0.6.1"),
      languages = listOf(
        LanguageEntry(name = "C<++>", url = "https://example.com/?q=a&b=c", version = "1&2"),
      ),
      frameworks = emptyList(),
      services = emptyList(),
      tools = emptyList(),
    )

    HtmlReporter(path, fs).report(report)

    val actual = fs.read(path) { readUtf8() }
    assertEquals(true, actual.contains("<td>C&lt;++&gt;</td>"))
    assertEquals(true, actual.contains("<code>1&amp;2</code>"))
    assertEquals(true, actual.contains("<a href=\"https://example.com/?q=a&amp;b=c\">https://example.com/?q=a&amp;b=c</a>"))
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
