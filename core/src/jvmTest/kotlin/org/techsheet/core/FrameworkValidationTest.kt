package org.techsheet.core

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class FrameworkValidationTest : AbstractValidationTest() {

  @TestFactory
  fun `valid framework ids`(): List<DynamicTest> = expectValid(
    "78334d1b-6ed4-408f-807b-776848b2ced0",
    "framework.spring-boot",
    "1",
    "abc",
    "1".repeat(50)
  ) {
    """
      frameworks:
      - id: "$it"
        name: "Some Framework"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid framework ids`(): List<DynamicTest> = expectInvalid(
    "" to "/frameworks/0/id: string length (0) must be greater or equal to 1",
    "???" to "/frameworks/0/id: string does not match pattern",
    "1".repeat(51) to "/frameworks/0/id: string length (51) must be less or equal to 50"
  ) {
    """
      frameworks:
      - id: "$it"
        name: "Some Framework"
    """.trimIndent()
  }

  @TestFactory
  fun `valid framework names`(): List<DynamicTest> = expectValid(
    "X",
    "Spring",
    "Spring Boot",
    "ASP.NET Core",
    "A".repeat(100)
  ) {
    """
      frameworks:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid framework names`(): List<DynamicTest> = expectInvalid(
    "" to "/frameworks/0/name: string length (0) must be greater or equal to 1",
    "A".repeat(101) to "/frameworks/0/name: string length (101) must be less or equal to 100"
  ) {
    """
      frameworks:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `valid framework categories`(): List<DynamicTest> = expectValid(
    "Application",
    "Frontend",
    "Testing",
    "Data Processing"
  ) {
    """
      frameworks:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Framework"
        category: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid framework categories`(): List<DynamicTest> = expectInvalid(
    "" to "/frameworks/0/category: string length (0) must be greater or equal to 1",
    "Category123" to "/frameworks/0/category: string does not match pattern"
  ) {
    """
      frameworks:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Framework"
        category: "$it"
    """.trimIndent()
  }
}
