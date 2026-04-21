package org.techsheet.cli.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VersionPickerTest {
  @Test fun `null and null yields null`() =
    assertEquals(null, pickVersion(null, null))

  @Test fun `null loses to non-null`() {
    assertEquals("1.0", pickVersion(null, "1.0"))
    assertEquals("1.0", pickVersion("1.0", null))
  }

  @Test fun `higher semver wins`() {
    assertEquals("3.0.1", pickVersion("3.0.0", "3.0.1"))
    assertEquals("3.0.1", pickVersion("3.0.1", "3.0.0"))
  }

  @Test fun `missing trailing components treated as zero`() {
    assertEquals("3.0.1", pickVersion("3.0", "3.0.1"))
    assertEquals("3", pickVersion("3", "2.9.99"))
  }

  @Test fun `semver beats non-semver`() {
    assertEquals("1.2.3", pickVersion("latest", "1.2.3"))
    assertEquals("1.2.3", pickVersion("1.2.3", "edge"))
  }

  @Test fun `two non-semver strings keep first-seen`() =
    assertEquals("latest", pickVersion("latest", "edge"))

  @Test fun `prerelease suffix ignored for ordering and first-seen tie-breaks`() =
    assertEquals("3.0.0-rc1", pickVersion("3.0.0-rc1", "3.0.0"))

  @Test fun `isSemverLike accepts canonical forms`() =
    listOf("1", "1.0", "1.0.0", "1.2.3", "3.0.0-rc1", "10.20.30")
      .forEach { assertTrue(isSemverLike(it), "expected semver: $it") }

  @Test fun `isSemverLike rejects non-canonical`() =
    listOf("latest", "edge", "", "v1.0")
      .forEach { assertFalse(isSemverLike(it), "expected non-semver: $it") }
}
