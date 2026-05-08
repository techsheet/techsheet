package org.techsheet.cli

import com.github.ajalt.clikt.testing.test
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.readText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class AnalyzerCommandTest : AbstractCommandTest() {

  // ###### default behaviour

  @Test
  fun `default mode prints console report to stdout`() {
    val output = run(emptyDir())
    assertContains(output, "───── TechSheet")
  }

  @Test
  fun `default mode writes techsheet yml to source directory`() {
    val dir = emptyDir()
    run(dir)
    assertTrue(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `default mode logs progress`() {
    val output = run(emptyDir())
    assertContains(output, "Starting project analysis")
    assertContains(output, "Project analyzed in")
  }

  // ###### verbosity flags

  @Test
  fun `-q suppresses logs and console report`() {
    val output = run("-q", emptyDir())
    assertFalse("Starting project analysis" in output)
    assertFalse("───── TechSheet" in output)
  }

  @Test
  fun `-q still writes the YAML file`() {
    val dir = emptyDir()
    run("-q", dir)
    assertTrue(Path.of(dir, "techsheet.yml").exists())
  }

  // ###### --read-only

  @Test
  fun `--read-only skips writing YAML file`() {
    val dir = emptyDir()
    run("--read-only", dir)
    assertFalse(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `--read-only still prints console report`() {
    val output = run("--read-only", emptyDir())
    assertContains(output, "───── TechSheet")
  }

  @Test
  fun `-r is shorthand for --read-only`() {
    val dir = emptyDir()
    run("-r", dir)
    assertFalse(Path.of(dir, "techsheet.yml").exists())
  }

  // ###### --file

  @Test
  fun `--file writes YAML to specified path`() {
    val dir = emptyDir()
    val custom = Path.of(dir, "custom.yml")
    run("--file=$custom", emptyDir())
    assertTrue(custom.exists())
    assertFalse(Path.of(dir, "techsheet.yml").exists(), "default file should not be written")
  }

  // ###### --report-* (file output)

  @Test
  fun `--report-json writes JSON file`() {
    val file = tempFile("techsheet.json")
    run("--report-json=$file", emptyDir())
    assertTrue(file.exists())
    assertContains(file.readText(), """"schema"""")
  }

  @Test
  fun `--report-markdown writes Markdown file`() {
    val file = tempFile("techsheet.md")
    run("--report-markdown=$file", emptyDir())
    assertTrue(file.exists())
    assertContains(file.readText(), "# TechSheet")
  }

  @Test
  fun `--report-html writes HTML file`() {
    val file = tempFile("techsheet.html")
    run("--report-html=$file", emptyDir())
    assertTrue(file.exists())
    assertContains(file.readText(), "<!DOCTYPE html>")
  }

  @Test
  fun `--report- does not suppress console report`() {
    val output = run("--report-json=${tempFile("t.json")}", emptyDir())
    assertTrue("───── TechSheet" in output, "--report-* should not suppress console report")
  }

  // ###### --output-* (stdout)

  @Test
  fun `--output-yaml prints YAML to stdout instead of console`() {
    val output = run("--output-yaml", emptyDir())
    assertContains(output, "schema:")
    assertFalse("───── TechSheet" in output)
  }

  @Test
  fun `--output-yaml still writes YAML file to disk`() {
    val dir = emptyDir()
    run("--output-yaml", dir)
    assertTrue(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `--output-json prints JSON to stdout instead of console`() {
    val output = run("--output-json", emptyDir())
    assertContains(output, """"schema"""")
    assertFalse("───── TechSheet" in output)
  }

  @Test
  fun `--output-markdown prints Markdown to stdout instead of console`() {
    val output = run("--output-markdown", emptyDir())
    assertContains(output, "# TechSheet")
    assertFalse("───── TechSheet" in output)
  }

  @Test
  fun `--output-html prints HTML to stdout instead of console`() {
    val output = run("--output-html", emptyDir())
    assertContains(output, "<!DOCTYPE html>")
    assertFalse("───── TechSheet" in output)
  }

  @Test
  fun `combining two --output- flags fails with error`() {
    val result = AnalyzerCommand().test("--output-json --output-yaml ${emptyDir()}")
    assertNotEquals(0, result.statusCode)
  }

  @Test
  fun `--output-json combined with --report-html writes HTML file and prints JSON`() {
    val htmlFile = tempFile("techsheet.html")
    val output = run("--output-json", "--report-html=$htmlFile", emptyDir())
    assertContains(output, """"schema"""")
    assertTrue(htmlFile.exists())
    assertContains(htmlFile.readText(), "<!DOCTYPE html>")
  }

  // ###### helpers

  private fun run(vararg args: String): String =
    AnalyzerCommand().test(args.joinToString(" ")).output
}
