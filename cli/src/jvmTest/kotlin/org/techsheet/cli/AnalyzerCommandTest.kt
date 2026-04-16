package org.techsheet.cli

import com.github.ajalt.clikt.core.parse
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.file.Files
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AnalyzerCommandTest {

  @Test
  fun `quiet mode skips the console report`() {
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf("-q", emptyDir()))
    }
    assertFalse(output.contains("TechSheet"), "expected no report in -q output, got: $output")
  }

  @Test
  fun `default mode prints the console report`() {
    val output = captureStdout {
      AnalyzerCommand().parse(arrayOf(emptyDir()))
    }
    assertTrue(output.contains("───── TechSheet"), "expected report header, got: $output")
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
