package org.techsheet.cli.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DetectionResultMergeTest {
  @Test fun `withLanguage dedupes by type`() = DetectionResult()
    .withLanguage(LanguageType.PYTHON, version = null)
    .withLanguage(LanguageType.PYTHON, version = "3.11")
    .run {
      assertEquals(1, languages.size)
      assertEquals("3.11", languages.single().version)
    }

  @Test fun `withLanguage keeps higher version when both non-null`() = DetectionResult()
    .withLanguage(LanguageType.PYTHON, version = "3.10")
    .withLanguage(LanguageType.PYTHON, version = "3.11")
    .let { assertEquals("3.11", it.languages.single().version) }

  @Test fun `withTool dedupes by type`() = DetectionResult()
    .withTool(ToolType.GRADLE, version = null)
    .withTool(ToolType.GRADLE, version = "8.5")
    .run {
      assertEquals(1, tools.size)
      assertEquals("8.5", tools.single().version)
    }

  @Test fun `plus dedupes across sheets`() {
    val a = DetectionResult().withLanguage(LanguageType.PYTHON, version = "3.10")
    val b = DetectionResult().withLanguage(LanguageType.PYTHON, version = "3.11")
    (a + b).run {
      assertEquals(1, languages.size)
      assertEquals("3.11", languages.single().version)
    }
  }

  @Test fun `hasLanguage true after add`() =
    assertTrue(DetectionResult().withLanguage(LanguageType.KOTLIN).hasLanguage(LanguageType.KOTLIN))

  @Test fun `hasLanguage false otherwise`() =
    assertFalse(DetectionResult().hasLanguage(LanguageType.KOTLIN))

  @Test fun `different types coexist`() = DetectionResult()
    .withLanguage(LanguageType.PYTHON)
    .withLanguage(LanguageType.KOTLIN)
    .let { assertEquals(2, it.languages.size) }
}
