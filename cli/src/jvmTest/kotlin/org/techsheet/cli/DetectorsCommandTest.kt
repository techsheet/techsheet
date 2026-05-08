package org.techsheet.cli

import com.github.ajalt.clikt.testing.test
import kotlin.io.path.exists
import kotlin.io.path.readText
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DetectorsCommandTest : AbstractCommandTest() {

  // ###### default behaviour

  @Test
  fun `default mode prints detector list`() {
    val output = run()
    assertContains(output, "───── TechSheet")
    assertContains(output, "Languages")
  }

  // ###### --markdown

  @Test
  fun `--markdown writes Markdown file`() {
    val file = tempFile("detectors.md")
    run("--markdown=$file")
    assertTrue(file.exists())
    assertContains(file.readText(), "# TechSheet Detectors")
  }

  @Test
  fun `--markdown skips console output`() {
    val output = run("--markdown=${tempFile("detectors.md")}")
    assertFalse("───── TechSheet" in output)
  }

  // ###### helpers

  private fun run(vararg args: String): String =
    DetectorsCommand().test(args.joinToString(" ")).output
}
