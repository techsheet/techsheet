package org.techsheet.cli

import com.github.ajalt.clikt.core.parse
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnalyzerCommandTest {

  @Test
  fun `default mode prints the console report`() {
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf(emptyDir()))
    }
    assertTrue(output.contains("───── TechSheet"), "expected report header, got: $output")
  }

  @Test
  fun `quiet silences logs but console fallback still prints when no reporter specified`() {
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf("-q", emptyDir()))
    }
    assertTrue(output.contains("───── TechSheet"), "expected console fallback in -q output, got: $output")
    assertFalse(
      output.contains("Starting project analysis"),
      "expected log lines suppressed under -q, got: $output",
    )
  }

  @Test
  fun `specifying --yaml suppresses the console fallback`() {
    val dir = emptyDir()
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf("--yaml", dir))
    }
    assertFalse(output.contains("───── TechSheet"), "expected no console report, got: $output")
    assertTrue(Path.of(dir, "techsheet.yml").exists(), "expected yaml file at $dir")
  }

  @Test
  fun `--console alongside --yaml activates both reporters`() {
    val dir = emptyDir()
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf("--console", "--yaml", dir))
    }
    assertTrue(output.contains("───── TechSheet"), "expected console report, got: $output")
    assertTrue(Path.of(dir, "techsheet.yml").exists(), "expected yaml file at $dir")
  }

  @Test
  fun `-q --console prints console report without log lines`() {
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf("-q", "--console", emptyDir()))
    }
    assertTrue(output.contains("───── TechSheet"), "expected console report, got: $output")
    assertFalse(
      output.contains("Starting project analysis"),
      "expected log lines suppressed under -q, got: $output",
    )
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
    Files
      .createTempDirectory("techsheet-cmd-test")
      .toString()
}
