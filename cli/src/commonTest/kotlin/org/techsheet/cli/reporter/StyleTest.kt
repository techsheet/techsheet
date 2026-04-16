package org.techsheet.cli.reporter

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StyleTest {

  @Test
  fun `fancy mode wraps text in ANSI codes and resets`() {
    val s = Style(plain = false)
    val out = s.cyan("hello")
    assertTrue(out.startsWith("\u001B[36m"), "expected cyan prefix, got: $out")
    assertTrue(out.endsWith("\u001B[0m"), "expected reset suffix, got: $out")
    assertTrue(out.contains("hello"))
  }

  @Test
  fun `plain mode returns text unchanged`() {
    val s = Style(plain = true)
    assertEquals("hello", s.cyan("hello"))
    assertEquals("hello", s.yellowBold("hello"))
    assertEquals("hello", s.green("hello"))
    assertEquals("hello", s.dim("hello"))
  }

  @Test
  fun `visibleLength strips ANSI sequences before measuring`() {
    val colored = Style(plain = false).cyan("hello")
    assertEquals(5, Style.visibleLength(colored))
    assertEquals(5, Style.visibleLength("hello"))
    assertEquals(0, Style.visibleLength(""))
  }

  @Test
  fun `visibleLength handles concatenated styled segments`() {
    val s = Style(plain = false)
    val combined = s.cyan("ab") + " " + s.dim("cd")
    assertEquals(5, Style.visibleLength(combined))
  }

  @Test
  fun `plain wraps add no codes anywhere`() {
    val s = Style(plain = true)
    val out = s.cyan("a") + s.dim("b") + s.green("c")
    assertFalse(out.contains("\u001B"), "plain output must contain no escape sequences: $out")
  }
}
