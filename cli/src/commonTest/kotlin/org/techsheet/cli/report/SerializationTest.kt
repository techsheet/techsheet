package org.techsheet.cli.report

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid
import org.techsheet.cli.domain.FrameworkEntry
import org.techsheet.cli.domain.LanguageEntry
import org.techsheet.cli.domain.Project
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
      project = Project(id = Uuid.parse("00000000-0000-0000-0000-000000000000"), name = "Test Project"),
      languages = listOf(
          LanguageEntry(id = "language.kotlin", name = "Kotlin", url = "https://techsheet.org/language/kotlin", version = "2.2.21"),
      ),
      frameworks = listOf(
          FrameworkEntry(
              id = "framework.spring-boot",
              name = "Spring Boot",
              category = "Application",
              url = "https://techsheet.org/framework/spring-boot",
              version = "4.0.5"
          ),
          FrameworkEntry(id = "framework.junit", name = "JUnit", category = "Testing", url = "https://techsheet.org/framework/junit"),
      ),
      services = emptyList(),
      tools = listOf(
          ToolEntry(id = "tool.git", name = "Git", category = "VCS", url = "https://techsheet.org/tool/git"),
      ),
  )

  @Test
  fun `serializes to pretty-printed JSON`() {
    val output = json.encodeToString(report)
    assertContains(output, """"schema": 2""")
    assertContains(output, """"id": "00000000-0000-0000-0000-000000000000"""")
    assertContains(output, """"name": "Test Project"""")
    assertContains(output, """"id": "language.kotlin"""")
    assertContains(output, """"name": "Kotlin"""")
    assertContains(output, """"version": "2.2.21"""")
    assertContains(output, """"id": "framework.spring-boot"""")
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
    assertContains(output, "schema: 2")
    assertContains(output, """"00000000-0000-0000-0000-000000000000"""")
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
