package org.techsheet.cli.domain

import kotlin.test.Test
import kotlin.test.assertEquals

class DetectedTechnologyTest {

  private val all: List<DetectedTechnology> =
    LanguageType.entries + FrameworkType.entries + ServiceType.entries + ToolType.entries

  @Test
  fun `every Technology id is globally unique`() {
    val duplicates = all.groupBy { it.id }.filterValues { it.size > 1 }.keys
    assertEquals(emptySet(), duplicates.toSet(), "duplicate ids: $duplicates")
  }

  @Test
  fun `every Technology url is globally unique`() {
    val duplicates = all.groupBy { it.url }.filterValues { it.size > 1 }.keys
    assertEquals(emptySet(), duplicates.toSet(), "duplicate urls: $duplicates")
  }
}
