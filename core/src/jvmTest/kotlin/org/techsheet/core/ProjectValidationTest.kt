package org.techsheet.core

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class ProjectValidationTest : AbstractValidationTest() {

  @TestFactory
  fun `valid project ids`(): List<DynamicTest> = expectValid(
    "ce770f52-e33b-47ba-a3c1-2198568348b9",
    "my-project",
    "workspace.projects.cms",
    "1",
    "1".repeat(50)
  ) {
    """
      project:
        id: "$it"
        name: "My Project"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid project ids`(): List<DynamicTest> = expectInvalid(
    "" to "/project/id: string length (0) must be greater or equal to 1",
    "MY-PROJECT" to "/project/id: string does not match pattern",
    "1".repeat(51) to "/project/id: string length (51) must be less or equal to 50"
  ) {
    """
      project:
        id: "$it"
        name: "My Project"
    """.trimIndent()
  }

  @TestFactory
  fun `valid project names`(): List<DynamicTest> = expectValid(
    "AB",
    "My Project",
    "User Management API",
    "CMS 2.0, Next-Gen",
    "A".repeat(200)
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid project names`(): List<DynamicTest> = expectInvalid(
    "" to "/project/name: string length (0) must be greater or equal to 2",
    "A" to "/project/name: string length (1) must be greater or equal to 2",
    "A".repeat(201) to "/project/name: string length (201) must be less or equal to 200",
    "My Project???" to "/project/name: string does not match pattern"
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `valid project descriptions`(): List<DynamicTest> = expectValid(
    "A",
    "REST API for managing user accounts and authentication.",
    "A".repeat(500)
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "My Project"
        description: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid project descriptions`(): List<DynamicTest> = expectInvalid(
    "" to "/project/description: string length (0) must be greater or equal to 1",
    "A".repeat(501) to "/project/description: string length (501) must be less or equal to 500"
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "My Project"
        description: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `valid team ids`(): List<DynamicTest> = expectValid(
    "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
    "team.platform",
    "1".repeat(50)
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "My Project"
        team:
          id: "$it"
          name: "Platform Engineering"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid team ids`(): List<DynamicTest> = expectInvalid(
    "" to "/project/team/id: string length (0) must be greater or equal to 1",
    "TEAM-ID" to "/project/team/id: string does not match pattern",
    "1".repeat(51) to "/project/team/id: string length (51) must be less or equal to 50"
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "My Project"
        team:
          id: "$it"
          name: "Platform Engineering"
    """.trimIndent()
  }

  @TestFactory
  fun `valid team names`(): List<DynamicTest> = expectValid(
    "A",
    "Platform Engineering",
    "Data & Analytics",
    "A".repeat(200)
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "My Project"
        team:
          id: "a1b2c3d4-e5f6-7890-abcd-ef1234567890"
          name: "$it"
    """.trimIndent()
  }

  @TestFactory
  fun `invalid team names`(): List<DynamicTest> = expectInvalid(
    "" to "/project/team/name: string length (0) must be greater or equal to 1",
    "A".repeat(201) to "/project/team/name: string length (201) must be less or equal to 200"
  ) {
    """
      project:
        id: "ce770f52-e33b-47ba-a3c1-2198568348b9"
        name: "My Project"
        team:
          id: "a1b2c3d4-e5f6-7890-abcd-ef1234567890"
          name: "$it"
    """.trimIndent()
  }
}
