package org.techsheet.cli.detector

import okio.Path.Companion.toPath
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.DetectionResult
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

private class FilenameOnlyMarker : AbstractFileMarkerFrameworkDetector(
  name = "Filename only",
  framework = FrameworkType.DJANGO,
  marker = Matcher.Filename("manage.py"),
)

private class ContentMatchNoVersion : AbstractFileMarkerFrameworkDetector(
  name = "Content gate",
  framework = FrameworkType.DJANGO,
  marker = Matcher.Filename("config.php"),
  // No capture group — content must match but no version is captured.
  contentMatch = Regex("""\bMARKER_TOKEN\b"""),
)

private class ContentMatchWithVersion : AbstractFileMarkerFrameworkDetector(
  name = "Content + version",
  framework = FrameworkType.WORDPRESS,
  marker = Matcher.Filename("version.php"),
  contentMatch = Regex("""\${'$'}wp_version\s*=\s*['"]([^'"]+)['"]"""),
)

class AbstractFileMarkerFrameworkDetectorTest {

  @Test fun `filename-only marker registers framework with no version`() {
    val result = FilenameOnlyMarker().onMatch("manage.py".toPath(), lazy { null }, DetectionResult())
    assertTrue(result.hasFramework(FrameworkType.DJANGO))
    assertNull(result.frameworks.first { it.type == FrameworkType.DJANGO }.version)
  }

  @Test fun `content-gated marker registers when content contains the signal`() {
    val result = ContentMatchNoVersion().onMatch(
      "config.php".toPath(), lazy { "<?php define('MARKER_TOKEN', true);" }, DetectionResult(),
    )
    assertTrue(result.hasFramework(FrameworkType.DJANGO))
  }

  @Test fun `content-gated marker leaves result unchanged when content lacks the signal`() {
    val result = ContentMatchNoVersion().onMatch(
      "config.php".toPath(), lazy { "<?php // unrelated config" }, DetectionResult(),
    )
    assertTrue(result.isEmpty())
  }

  @Test fun `content-gated marker leaves result unchanged when content is null`() {
    val result = ContentMatchNoVersion().onMatch(
      "config.php".toPath(), lazy { null }, DetectionResult(),
    )
    assertTrue(result.isEmpty())
  }

  @Test fun `content-gated marker captures version from group 1`() {
    val versionPhp = "<?php\n\$wp_version = '6.5.2';\n\$wp_db_version = 57155;\n"
    val result = ContentMatchWithVersion().onMatch(
      "version.php".toPath(), lazy { versionPhp }, DetectionResult(),
    )
    assertEquals("6.5.2", result.frameworks.first { it.type == FrameworkType.WORDPRESS }.version)
  }
}
