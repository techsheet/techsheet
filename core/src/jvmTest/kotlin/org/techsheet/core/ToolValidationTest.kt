package org.techsheet.core

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class ToolValidationTest : AbstractValidationTest() {

  @TestFactory
  fun `valid tool ids`(): List<DynamicTest> = expectValid(
    "78334d1b-6ed4-408f-807b-776848b2ced0",
    "tool.gradle",
    "1",
    "abc",
    "1".repeat(50)
  ) {
    """
      tools:
      - id: "$it"
        name: "Some Tool"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid tool ids`(): List<DynamicTest> = expectInvalid(
    "" to "/tools/0/id: string length (0) must be greater or equal to 1",
    "???" to "/tools/0/id: string does not match pattern",
    "1".repeat(51) to "/tools/0/id: string length (51) must be less or equal to 50"
  ) {
    """
      tools:
      - id: "$it"
        name: "Some Tool"
    """.trimIndent()
  }

  @TestFactory
  fun `valid tool names`(): List<DynamicTest> = expectValid(
    "X",
    "Docker",
    "Gradle",
    "GitHub Actions",
    "A".repeat(100)
  ) {
    """
      tools:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid tool names`(): List<DynamicTest> = expectInvalid(
    "" to "/tools/0/name: string length (0) must be greater or equal to 1",
    "A".repeat(101) to "/tools/0/name: string length (101) must be less or equal to 100"
  ) {
    """
      tools:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `valid tool categories`(): List<DynamicTest> = expectValid(
    "Build",
    "Container",
    "CI-CD",
    "Static Analysis"
  ) {
    """
      tools:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Tool"
        category: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid tool categories`(): List<DynamicTest> = expectInvalid(
    "" to "/tools/0/category: string length (0) must be greater or equal to 1",
    "Category123" to "/tools/0/category: string does not match pattern"
  ) {
    """
      tools:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Tool"
        category: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `valid tool flavors`(): List<DynamicTest> = expectValid(
    "Kotlin DSL",
    "Groovy DSL",
    "5+ version",
    "A".repeat(100)
  ) {
    """
      tools:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Tool"
        flavor: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid tool flavors`(): List<DynamicTest> = expectInvalid(
    "" to "/tools/0/flavor: string length (0) must be greater or equal to 1",
    "A".repeat(101) to "/tools/0/flavor: string length (101) must be less or equal to 100"
  ) {
    """
      tools:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Tool"
        flavor: "$it"
    """.trimIndent()
  }
}
