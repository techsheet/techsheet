package org.techsheet.cli.detector

import okio.Path.Companion.toPath
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.Matcher
import org.techsheet.cli.domain.TechSheet
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
    val sheet = FilenameOnlyMarker().onMatch("manage.py".toPath(), lazy { null }, TechSheet.empty())
    assertTrue(sheet.hasFramework(FrameworkType.DJANGO))
    assertNull(sheet.frameworks.first { it.type == FrameworkType.DJANGO }.version)
  }

  @Test fun `content-gated marker registers when content contains the signal`() {
    val sheet = ContentMatchNoVersion().onMatch(
      "config.php".toPath(), lazy { "<?php define('MARKER_TOKEN', true);" }, TechSheet.empty(),
    )
    assertTrue(sheet.hasFramework(FrameworkType.DJANGO))
  }

  @Test fun `content-gated marker leaves sheet unchanged when content lacks the signal`() {
    val sheet = ContentMatchNoVersion().onMatch(
      "config.php".toPath(), lazy { "<?php // unrelated config" }, TechSheet.empty(),
    )
    assertTrue(sheet.isEmpty())
  }

  @Test fun `content-gated marker leaves sheet unchanged when content is null`() {
    val sheet = ContentMatchNoVersion().onMatch(
      "config.php".toPath(), lazy { null }, TechSheet.empty(),
    )
    assertTrue(sheet.isEmpty())
  }

  @Test fun `content-gated marker captures version from group 1`() {
    val versionPhp = "<?php\n\$wp_version = '6.5.2';\n\$wp_db_version = 57155;\n"
    val sheet = ContentMatchWithVersion().onMatch(
      "version.php".toPath(), lazy { versionPhp }, TechSheet.empty(),
    )
    assertEquals("6.5.2", sheet.frameworks.first { it.type == FrameworkType.WORDPRESS }.version)
  }
}
