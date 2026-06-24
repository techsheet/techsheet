package org.techsheet.core

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import okio.FileSystem
import okio.Path.Companion.toPath
import org.junit.jupiter.api.DynamicTest

abstract class AbstractValidationTest {

  private val schemaContent = FileSystem.SYSTEM.read(
    "../docs/content/spec/v2/techsheet.json".toPath()
  ) { readUtf8() }

  private val parser = Parser(
    SchemaLoader(
      httpClient = HttpClient(MockEngine { respond(schemaContent, HttpStatusCode.OK) }),
    )
  )

  fun expectValid(vararg values: String, yaml: (String) -> String): List<DynamicTest> =
    values.map { value ->
      DynamicTest.dynamicTest(value) {
        val result = parser.parse(yaml(value))
        assert(result.isSuccess) { "Expected success but got: $result" }
      }
    }

  fun expectInvalid(vararg values: Pair<String, String>, yaml: (String) -> String): List<DynamicTest> =
    values.map { (value, expectedError) ->
      DynamicTest.dynamicTest("\"$value\": $expectedError") {
        val result = parser.parse(yaml(value))
        assert(result.isFailure) { "Expected failure but parsed successfully" }
        val errors = (result as ParserResult.Failure).errors
        assert(errors.any { it.contains(expectedError) }) {
          "Expected error containing '$expectedError' but got: $errors"
        }
      }
    }
}
