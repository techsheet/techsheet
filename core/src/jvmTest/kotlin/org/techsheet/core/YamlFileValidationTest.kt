package org.techsheet.core

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class YamlFileValidationTest {

  private val schemaContent = FileSystem.SYSTEM.read(
    "../docs/content/spec/v2/techsheet.json".toPath()
  ) { readUtf8() }

  private val parser = Parser(
    SchemaLoader(
      httpClient = HttpClient(MockEngine { respond(schemaContent, HttpStatusCode.OK) }),
    )
  )

  @TestFactory
  fun `parse valid`(): List<DynamicTest> {
    val files = filesFromDir("src/jvmTest/resources/validation/valid")

    if (files.isEmpty()) {
      return listOf(dynamicTest("discover fixtures") {
        fail("No YAML fixtures found")
      })
    }

    return files.map { path ->
      dynamicTest(path.name) {
        val yaml = FileSystem.SYSTEM.read(path) { readUtf8() }
        val result = parser.parse(yaml)
        assertTrue(
          result.isSuccess,
          "Expected valid but got errors: ${(result as? ParserResult.Failure)?.errors}",
        )
      }
    }
  }

  @TestFactory
  fun `parse invalid`(): List<DynamicTest> {
    val files = filesFromDir("src/jvmTest/resources/validation/invalid")

    if (files.isEmpty()) {
      return listOf(dynamicTest("discover fixtures") {
        fail("No YAML fixtures found")
      })
    }

    return files.map { path ->
      dynamicTest(path.name) {
        val yaml = FileSystem.SYSTEM.read(path) { readUtf8() }
        val result = parser.parse(yaml)
        assertFalse(
          result.isSuccess,
          "Expected invalid but parsed successfully",
        )
      }
    }
  }

  private fun filesFromDir(dir: String): List<Path> =
    FileSystem.SYSTEM.list(dir.toPath())
      .filter { it.name.endsWith(".yml") || it.name.endsWith(".yaml") }
      .sortedBy { it.name }
}
