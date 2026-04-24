package org.techsheet.cli.reporter

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
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
import kotlin.test.assertTrue

class YamlReporterTest {

  private val yaml = Yaml(
    configuration = YamlConfiguration(
      encodeDefaults = false,
      strictMode = false,
      sequenceBlockIndent = 2,
    ),
  )

  @Test
  fun `serialized yaml round-trips to an equal report`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.yml".toPath()

    YamlReporter(path, fs).report(SAMPLE_REPORT)

    val content = fs.read(path) { readUtf8() }
    val parsed = yaml.decodeFromString(TechSheetReport.serializer(), content)
    assertEquals(SAMPLE_REPORT, parsed)
  }

  @Test
  fun `serialized yaml omits entries with null version`() {
    val fs = FakeFileSystem()
    val path = "/out/techsheet.yml".toPath()
    val report = TechSheetReport(
      meta = ReportMeta(
        generatedAt = Instant.parse("2026-04-21T17:37:00Z"),
        generatorVersion = "0.6.1",
      ),
      languages = listOf(
        LanguageEntry(id = "language.bash", name = "Bash", url = "https://techsheet.org/language/bash", version = null),
      ),
      frameworks = emptyList(),
      services = emptyList(),
      tools = emptyList(),
    )

    YamlReporter(path, fs).report(report)

    val content = fs.read(path) { readUtf8() }
    assertTrue(
      !content.contains("version:"),
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
    LanguageEntry(id = "language.java", name = "Java", url = "https://techsheet.org/language/java", version = "21"),
  ),
  frameworks = listOf(
    FrameworkEntry(id = "framework.angular", name = "Angular", category = "Application", url = "https://techsheet.org/framework/angular", version = "21.2.4"),
  ),
  services = listOf(
    ServiceEntry(id = "service.postgres", name = "Postgres", category = "Database", url = "https://techsheet.org/service/postgres", version = "16.1"),
  ),
  tools = listOf(
    ToolEntry(id = "tool.gradle", name = "Gradle", category = "Build", url = "https://techsheet.org/tool/gradle", version = "8.14.1", flavor = "kotlin"),
  ),
)
