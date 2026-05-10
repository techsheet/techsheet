package org.techsheet.cli.report

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import kotlinx.serialization.json.Json
import kotlin.uuid.Uuid
import org.techsheet.schema.Framework
import org.techsheet.schema.Language
import org.techsheet.schema.Project
import org.techsheet.schema.TechSheet
import org.techsheet.schema.Tool
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse

class SerializationTest {

  private val json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
    explicitNulls = false
  }

  private val techSheet = TechSheet(
      project = Project(id = Uuid.parse("00000000-0000-0000-0000-000000000000"), name = "Test Project"),
      languages = listOf(
          Language(id = "language.kotlin", name = "Kotlin", url = "https://techsheet.org/language/kotlin", version = "2.2.21"),
      ),
      frameworks = listOf(
          Framework(
              id = "framework.spring-boot",
              name = "Spring Boot",
              category = "Application",
              url = "https://techsheet.org/framework/spring-boot",
              version = "4.0.5"
          ),
          Framework(id = "framework.junit", name = "JUnit", category = "Testing", url = "https://techsheet.org/framework/junit"),
      ),
      services = emptyList(),
      tools = listOf(
          Tool(id = "tool.git", name = "Git", category = "VCS", url = "https://techsheet.org/tool/git"),
      ),
  )

  @Test
  fun `serializes to pretty-printed JSON`() {
    val output = json.encodeToString(techSheet)
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
    val output = json.encodeToString(techSheet)
    val gitSection = output.substringAfter(""""name": "Git"""")
      .substringBefore("}")
    assertFalse(gitSection.contains("version"))
  }

  @Test
  fun `empty services list serializes as empty array`() {
    val output = json.encodeToString(techSheet)
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
    val output = yaml.encodeToString(TechSheet.serializer(), techSheet)
    assertContains(output, "schema: 2")
    assertContains(output, """"00000000-0000-0000-0000-000000000000"""")
    assertContains(output, "name: \"Kotlin\"")
    assertContains(output, "category: \"Application\"")
    assertContains(output, "category: \"VCS\"")
  }

  @Test
  fun `YAML omits null versions`() {
    val output = yaml.encodeToString(TechSheet.serializer(), techSheet)
    val lines = output.lines()
    val gitLine = lines.indexOfFirst { it.contains("name: \"Git\"") }
    val nextEntry = lines.drop(gitLine + 1).indexOfFirst { it.trimStart().startsWith("- ") || !it.startsWith(" ") }
    val gitBlock = lines.subList(gitLine, gitLine + nextEntry + 1).joinToString("\n")
    assertFalse(gitBlock.contains("version"))
  }
}
