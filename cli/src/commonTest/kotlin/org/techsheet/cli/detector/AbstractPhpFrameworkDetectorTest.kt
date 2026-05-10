package org.techsheet.cli.detector

import okio.Path.Companion.toPath
import org.techsheet.cli.domain.FrameworkType
import org.techsheet.cli.domain.DetectionResult
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

private class PhpTestDetector(
  packageNames: List<String> = listOf("laravel/framework"),
) : AbstractPhpFrameworkDetector(
  name = "Test",
  framework = FrameworkType.LARAVEL,
  packageNames = packageNames,
)

private fun analyzePhp(
  filename: String,
  content: String,
  packageNames: List<String> = listOf("laravel/framework"),
): DetectionResult = PhpTestDetector(packageNames)
  .onMatch(filename.toPath(), lazy { content }, DetectionResult())

private fun DetectionResult.laravelVersion(): String? =
  frameworks.firstOrNull { it.type == FrameworkType.LARAVEL }?.version

class AbstractPhpFrameworkDetectorTest {

  // ---------- composer.json ----------

  @Test fun `composer json detects package in require with caret version`() {
    val json = """
      {
        "require": {
          "php": "^8.2",
          "laravel/framework": "^11.0"
        }
      }
    """.trimIndent()
    assertEquals("11.0", analyzePhp("composer.json", json).laravelVersion())
  }

  @Test fun `composer json detects package in require-dev`() {
    val json = """
      {
        "require-dev": {
          "laravel/framework": "~10.5.2"
        }
      }
    """.trimIndent()
    assertEquals("10.5.2", analyzePhp("composer.json", json).laravelVersion())
  }

  @Test fun `composer json strips greater-than-or-equal prefix`() {
    val json = """{"require":{"laravel/framework":">=9.1"}}"""
    assertEquals("9.1", analyzePhp("composer.json", json).laravelVersion())
  }

  @Test fun `composer json missing package leaves result unchanged`() {
    val json = """{"require":{"symfony/console":"^6.0"}}"""
    assertTrue(analyzePhp("composer.json", json).isEmpty())
  }

  @Test fun `composer json with multiple package names matches any one`() {
    val json = """{"require":{"symfony/symfony":"^5.4"}}"""
    val result = analyzePhp(
      "composer.json", json,
      packageNames = listOf("symfony/framework-bundle", "symfony/symfony"),
    )
    assertTrue(result.hasFramework(FrameworkType.LARAVEL))
    assertEquals("5.4", result.laravelVersion())
  }

  @Test fun `malformed composer json is tolerated`() {
    val json = """{"require": { "laravel/framework": "^11.0", broken"""
    assertEquals("11.0", analyzePhp("composer.json", json).laravelVersion())
  }

  @Test fun `empty composer json leaves result unchanged`() {
    assertTrue(analyzePhp("composer.json", "").isEmpty())
  }

  // ---------- composer.lock ----------

  @Test fun `composer lock detects resolved version from packages entry`() {
    val lock = """
      {
        "packages": [
          {
            "name": "laravel/framework",
            "version": "v11.5.2",
            "source": { "type": "git", "url": "..." }
          }
        ]
      }
    """.trimIndent()
    assertEquals("11.5.2", analyzePhp("composer.lock", lock).laravelVersion())
  }

  @Test fun `composer lock picks correct entry among many`() {
    val lock = """
      {
        "packages": [
          { "name": "symfony/console", "version": "v6.4.0" },
          { "name": "laravel/framework", "version": "v11.5.2" },
          { "name": "monolog/monolog", "version": "3.5.0" }
        ]
      }
    """.trimIndent()
    assertEquals("11.5.2", analyzePhp("composer.lock", lock).laravelVersion())
  }

  @Test fun `composer lock without target package leaves result unchanged`() {
    val lock = """
      {
        "packages": [
          { "name": "symfony/console", "version": "v6.4.0" }
        ]
      }
    """.trimIndent()
    assertNull(analyzePhp("composer.lock", lock).laravelVersion())
  }
}
