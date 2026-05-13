package org.techsheet.core

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class ServiceValidationTest : AbstractValidationTest() {

  @TestFactory
  fun `valid service ids`(): List<DynamicTest> = expectValid(
    "78334d1b-6ed4-408f-807b-776848b2ced0",
    "service.postgres",
    "1",
    "abc",
    "1".repeat(50)
  ) {
    """
      services:
      - id: "$it"
        name: "Some Service"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid service ids`(): List<DynamicTest> = expectInvalid(
    "" to "/services/0/id: string length (0) must be greater or equal to 1",
    "???" to "/services/0/id: string does not match pattern",
    "1".repeat(51) to "/services/0/id: string length (51) must be less or equal to 50"
  ) {
    """
      services:
      - id: "$it"
        name: "Some Service"
    """.trimIndent()
  }

  @TestFactory
  fun `valid service names`(): List<DynamicTest> = expectValid(
    "X",
    "Redis",
    "PostgreSQL",
    "AWS S3",
    "A".repeat(100)
  ) {
    """
      services:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid service names`(): List<DynamicTest> = expectInvalid(
    "" to "/services/0/name: string length (0) must be greater or equal to 1",
    "A".repeat(101) to "/services/0/name: string length (101) must be less or equal to 100"
  ) {
    """
      services:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `valid service categories`(): List<DynamicTest> = expectValid(
    "Database",
    "Cache",
    "Messaging",
    "Cloud Storage"
  ) {
    """
      services:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Service"
        category: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid service categories`(): List<DynamicTest> = expectInvalid(
    "" to "/services/0/category: string length (0) must be greater or equal to 1",
    "Category123" to "/services/0/category: string does not match pattern"
  ) {
    """
      services:
      - id: "d814f9d2-f23f-40e9-848c-6f220c0c9baf"
        name: "Some Service"
        category: "$it"
    """.trimIndent()
  }
}
