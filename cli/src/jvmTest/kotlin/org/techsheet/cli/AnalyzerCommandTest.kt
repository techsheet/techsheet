package org.techsheet.cli

import com.github.ajalt.clikt.core.parse
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.io.path.readText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnalyzerCommandTest {

  // ###### default behaviour

  @Test
  fun `default mode prints console report to stdout`() {
    val stdout = run(emptyDir())
    assertContains(stdout, "───── TechSheet")
  }

  @Test
  fun `default mode writes techsheet yml to source directory`() {
    val dir = emptyDir()
    run(dir)
    assertTrue(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `default mode logs progress`() {
    val stdout = run(emptyDir())
    assertContains(stdout, "Starting project analysis")
    assertContains(stdout, "Project analyzed in")
  }

  // ###### verbosity flags

  @Test
  fun `-q suppresses logs and console report`() {
    val stdout = run("-q", emptyDir())
    assertFalse("Starting project analysis" in stdout)
    assertFalse("───── TechSheet" in stdout)
  }

  @Test
  fun `-q still writes the YAML file`() {
    val dir = emptyDir()
    run("-q", dir)
    assertTrue(Path.of(dir, "techsheet.yml").exists())
  }

  // ###### read-only / ci

  @Test
  fun `--read-only skips writing YAML file`() {
    val dir = emptyDir()
    run("--read-only", dir)
    assertFalse(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `--read-only still prints console report`() {
    val stdout = run("--read-only", emptyDir())
    assertContains(stdout, "───── TechSheet")
  }

  @Test
  fun `-r is shorthand for --read-only`() {
    val dir = emptyDir()
    run("-r", dir)
    assertFalse(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `--ci skips writing YAML file`() {
    val dir = emptyDir()
    run("--ci", dir)
    assertFalse(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `--ci prints console report in plain mode (no ANSI)`() {
    val stdout = run("--ci", emptyDir())
    assertContains(stdout, "───── TechSheet")
    assertFalse("[" in stdout, "expected no ANSI escape codes with --ci")
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
    val stdout = run("--report-json=${tempFile("t.json")}", emptyDir())
    assertTrue("───── TechSheet" in stdout, "--report-* should not suppress console report")
  }

  // ###### --output-* (stdout)

  @Test
  fun `--output-yaml prints YAML to stdout instead of console`() {
    val stdout = run("--output-yaml", emptyDir())
    assertContains(stdout, "schema:")
    assertFalse("───── TechSheet" in stdout)
  }

  @Test
  fun `--output-yaml still writes YAML file to disk`() {
    val dir = emptyDir()
    run("--output-yaml", dir)
    assertTrue(Path.of(dir, "techsheet.yml").exists())
  }

  @Test
  fun `--output-json prints JSON to stdout instead of console`() {
    val stdout = run("--output-json", emptyDir())
    assertContains(stdout, """"schema"""")
    assertFalse("───── TechSheet" in stdout)
  }

  @Test
  fun `--output-markdown prints Markdown to stdout instead of console`() {
    val stdout = run("--output-markdown", emptyDir())
    assertContains(stdout, "# TechSheet")
    assertFalse("───── TechSheet" in stdout)
  }

  @Test
  fun `--output-html prints HTML to stdout instead of console`() {
    val stdout = run("--output-html", emptyDir())
    assertContains(stdout, "<!DOCTYPE html>")
    assertFalse("───── TechSheet" in stdout)
  }

  @Test
  fun `combining two --output- flags fails with error`() {
    assertFails {
      AnalyzerCommand().parse(arrayOf("--output-json", "--output-yaml", emptyDir()))
    }
  }

  @Test
  fun `--output-json combined with --report-html writes HTML file and prints JSON`() {
    val htmlFile = tempFile("techsheet.html")
    val stdout = run("--output-json", "--report-html=$htmlFile", emptyDir())
    assertContains(stdout, """"schema"""")
    assertTrue(htmlFile.exists())
    assertContains(htmlFile.readText(), "<!DOCTYPE html>")
  }

  // ###### helpers

  private fun run(vararg args: String): String = captureStdout {
    AnalyzerCommand().parse(arrayOf(*args))
  }

  private fun captureStdout(block: () -> Unit): String {
    val buffer = ByteArrayOutputStream()
    val original = System.out
    System.setOut(PrintStream(buffer))
    try {
      block()
    } finally {
      System.setOut(original)
    }
    return buffer.toString()
  }

  private fun emptyDir(): String =
    Files.createTempDirectory("techsheet-cmd-test").toString()

  private fun tempFile(name: String): Path =
    Files.createTempDirectory("techsheet-cmd-test").resolve(name)
}
