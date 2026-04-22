@file:OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)

package org.techsheet.cli.report

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import kotlin.time.Instant
import kotlinx.serialization.json.Json
import org.techsheet.cli.domain.FrameworkEntry
import org.techsheet.cli.domain.LanguageEntry
import org.techsheet.cli.domain.ReportMeta
import org.techsheet.cli.domain.TechSheetReport
import org.techsheet.cli.domain.ToolEntry
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class SerializationTest {

  private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
    explicitNulls = false
  }

  private val report = TechSheetReport(
      meta = ReportMeta(
        generatedAt = Instant.parse("2026-04-17T20:15:00Z"),
        generatorVersion = "0.5.0",
      ),
      languages = listOf(
          LanguageEntry(name = "Kotlin", url = "https://techsheet.org/language/kotlin", version = "2.2.21"),
      ),
      frameworks = listOf(
          FrameworkEntry(
              name = "Spring Boot",
              url = "https://techsheet.org/framework/spring-boot",
              category = "Application",
              version = "4.0.5"
          ),
          FrameworkEntry(name = "JUnit", url = "https://techsheet.org/framework/junit", category = "Testing"),
      ),
      services = emptyList(),
      tools = listOf(
          ToolEntry(name = "Git", url = "https://techsheet.org/tool/git", category = "VCS"),
      ),
  )

  @Test
  fun `serializes to pretty-printed JSON`() {
    val output = json.encodeToString(report)
    assertContains(output, """"schema": 1""")
    assertContains(output, """"generatedAt": "2026-04-17T20:15:00Z"""")
    assertContains(output, """"generatorVersion": "0.5.0"""")
    assertContains(output, """"name": "Kotlin"""")
    assertContains(output, """"version": "2.2.21"""")
    assertContains(output, """"category": "Application"""")
    assertContains(output, """"category": "Testing"""")
    assertContains(output, """"category": "VCS"""")
  }

  @Test
  fun `omits null versions`() {
    val output = json.encodeToString(report)
    val gitSection = output.substringAfter(""""name": "Git"""")
      .substringBefore("}")
    assertFalse(gitSection.contains("version"))
  }

  @Test
  fun `empty services list serializes as empty array`() {
    val output = json.encodeToString(report)
    assertContains(output, """"services": []""")
  }

  private val yaml = Yaml(
    configuration = YamlConfiguration(
      encodeDefaults = false,
      strictMode = false,
    ),
  )

  @Test
  fun `serializes to YAML`() {
    val output = yaml.encodeToString(TechSheetReport.serializer(), report)
    assertContains(output, "schema: 1")
    assertContains(output, """generatedAt: "2026-04-17T20:15:00Z"""")
    assertContains(output, """generatorVersion: "0.5.0"""")
    assertContains(output, "name: \"Kotlin\"")
    assertContains(output, "category: \"Application\"")
    assertContains(output, "category: \"VCS\"")
  }

  @Test
  fun `YAML omits null versions`() {
    val output = yaml.encodeToString(TechSheetReport.serializer(), report)
    val lines = output.lines()
    val gitLine = lines.indexOfFirst { it.contains("name: \"Git\"") }
    val nextEntry = lines.drop(gitLine + 1).indexOfFirst { it.trimStart().startsWith("- ") || !it.startsWith(" ") }
    val gitBlock = lines.subList(gitLine, gitLine + nextEntry + 1).joinToString("\n")
    assertFalse(gitBlock.contains("version"))
  }
}
