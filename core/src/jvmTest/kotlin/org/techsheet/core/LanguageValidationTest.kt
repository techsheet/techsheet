package org.techsheet.core

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class LanguageValidationTest : AbstractValidationTest() {

  @TestFactory
  fun `valid language ids`(): List<DynamicTest> = expectValid(
    "78334d1b-6ed4-408f-807b-776848b2ced0",
    "language.kotlin",
    "1",
    "abc",
    "1".repeat(50)
  ) {
    """
      languages:
      - id: "$it"
        name: "Some Language"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid language ids`(): List<DynamicTest> = expectInvalid(
    "" to "/languages/0/id: string length (0) must be greater or equal to 1",
    "???" to "/languages/0/id: string does not match pattern",
    "1".repeat(51) to "/languages/0/id: string length (51) must be less or equal to 50"
  ) {
    """
      languages:
      - id: "$it"
        name: "Some Language"
    """.trimIndent()
  }

  @TestFactory
  fun `valid language names`(): List<DynamicTest> = expectValid(
    "R",
    "Go",
    "C#",
    "C++",
    "Kotlin",
    "JavaScript",
    "A".repeat(100)
  ) {
    """
      languages:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid language names`(): List<DynamicTest> = expectInvalid(
    "" to "/languages/0/name: string length (0) must be greater or equal to 1",
    "A".repeat(101) to "/languages/0/name: string length (101) must be less or equal to 100",
  ) {
    """
      languages:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }
}
